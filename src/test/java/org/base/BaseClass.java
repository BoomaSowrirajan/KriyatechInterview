package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Alert al;
	public static Actions a;
	public static JavascriptExecutor js;
	public static Select s;
	public static TakesScreenshot t;
	public static Robot r;
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static File f;
	public static FileInputStream fis;

	// 1. Browser Launch and Window Maximize

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void chromeBrowserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// 2. Get Page Title

	public static void getPageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	// 3. Get Current Page URL

	public static void getPageUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	// 4. Launch URL

	public static void launchUrl(String url) {
		driver.get(url);
	}

	// 5. SendKeys Method

	public static void typeText(WebElement ref, String value) {
		ref.sendKeys(value);
	}

	// 6. Click Method

	public static void clickButton(WebElement ref) {
		ref.click();
	}

	// 7. Close browser

	public static void closeBrowser() {
		driver.close();
	}

	// 8. Quit Window

	public static void quitWindow() {
		driver.quit();
	}

	// 9. Take Screenshot

	public static void takeScreenshot(String filepath) throws IOException {
		t = (TakesScreenshot) driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		File destination = new File(filepath);
		FileUtils.copyFile(source, destination);

	}

	// 10. Alert Accept, and Pass Text in Alert

	public static void alertAccept() {
		al = driver.switchTo().alert();
		al.accept();
	}

	// 11. Alert Dismiss

	public static void alertDismiss() {
		al = driver.switchTo().alert();
		al.dismiss();
	}

	// 12. Alert Pass Text

	public static void alertSendText(String text) {
		al = driver.switchTo().alert();
		al.sendKeys(text);
		al.accept();
	}

	// 13. Get Text from Alert Box

	public static void alertGetText() {
		al = driver.switchTo().alert();
		String text = al.getText();
		System.out.println(text);
	}

	// 14. Actions Move to Element

	public static void actionsMovetoElem(WebElement ref) {
		a = new Actions(driver);
		a.moveToElement(ref).perform();
	}

	// 15. Actions Drag and drop

	public static void actionsDragDrop(WebElement source, WebElement destn) {
		a = new Actions(driver);
		a.dragAndDrop(source, destn).perform();
	}

	// 16. Actions Right click
	public static void actionsDoubleClick(WebElement reference) {
		a = new Actions(driver);
		a.doubleClick(reference).perform();
	}

	// 17. Actions Double click

	public static void actionsRightClick(WebElement variable) {
		a = new Actions(driver);
		a.contextClick(variable).perform();
	}

	// 18. Switching to Frames by using Webelement Reference

	public static void switchToFrameByRef(WebElement ref) {
		driver.switchTo().frame(ref);
	}

	// 19. Switching to Frames by using Id

	public static void switchToFrameById(String id) {
		driver.switchTo().frame(id);
	}

	// 20. Switching to Frames by using Name

	public static void switchToFrameByName(String name) {
		driver.switchTo().frame(name);
	}

	// 21. Switching to Frames by using Index

	public static void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 22. Switching to main HTML from any frame

	public static void switchToMain() {
		driver.switchTo().defaultContent();
	}

	// 23. Switching to parent from from child frame

	public static void switchtoParent() {
		driver.switchTo().parentFrame();
	}

	// 24. Handling a Window and switching by using WindowID (checking Condition)

	public static void switchToWindowByWindowID() {

		String parent = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		for (String i : allwindows) {
			if (parent != i) {
				driver.switchTo().window(i);
			}
		}
	}

	// 25. Handling a Window and switching by using Title

	public static void switchToWindowByTitle(String title) {
		driver.switchTo().window(title);
	}

	// 26. Handling a Window and switching by using URL

	public static void switchToWindowByUrl(String url) {
		driver.switchTo().window(url);
	}

	// 27. Handling Multiple Windows

	public static void switchToMultipleWindows(int index) {

		Set<String> allwindows = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(allwindows);
		driver.switchTo().window(li.get(index));
	}

	// 28. Select by using index

	public static void selectByIndex(WebElement ref, int index) {
		s = new Select(ref);
		s.selectByIndex(index);
	}

	// 29. Select by using Visible Text

	public static void selectByName(WebElement ref, String name) {
		s = new Select(ref);
		s.selectByVisibleText(name);
	}

	// 30. Select by using Value

	public static void selectByValue(WebElement ref, String value) {
		s = new Select(ref);
		s.selectByValue(value);
	}

	// 31. SelectAll

	public static void selectAll(WebElement ref) {
		s = new Select(ref);
		s.isMultiple();
		List<WebElement> alloptions = s.getOptions();
		for (int i = 0; i < alloptions.size(); i++) {
			s.selectByIndex(i);
		}
	}

	// 32. Deselect by using index

	public static void deselectByIndex(WebElement ref, int index) {
		s = new Select(ref);
		s.deselectByIndex(index);
	}

	// 33. Deselect by using Visible Text

	public static void deselectByName(WebElement ref, String name) {
		s = new Select(ref);
		s.deselectByVisibleText(name);
	}

	// 34. Deselect by using Value

	public static void deselectByValue(WebElement ref, String value) {
		s = new Select(ref);
		s.deselectByValue(value);
	}

	// 35. Deselect All

	public static void deSelectAll(WebElement ref) {
		s = new Select(ref);
		s.deselectAll();
	}

	// 36. All selected options in select class

	public static List<WebElement> allSelectedOptions(WebElement ref) {
		s = new Select(ref);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		System.out.println("All Selected Options are : ");
		for (WebElement options : allSelectedOptions) {
			String text = options.getText();
			System.out.println(text);
		}
		return allSelectedOptions;
	}

	// 37. Get Options in select class

	public static List<WebElement> getAllOptions(WebElement ref) {
		s = new Select(ref);
		List<WebElement> allOptions = s.getOptions();
		System.out.println("All Options are : ");
		for (WebElement options : allOptions) {
			String text = options.getText();
			System.out.println(text);
		}

		return allOptions;
	}

	// 38. First selected option in Select class

	public static void firstSelectedOption(WebElement ref) {
		s = new Select(ref);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println("First Selected Option is : " + text);
	}

	// 39. To check Multiple select option using isMultiple in select class

	public static void multipleSelect(WebElement ref) {
		s = new Select(ref);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	// 40. Java Script Executor ScrollDown

	public static void scrollDown(WebElement ref) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", ref);
	}

	// 41. Java Script Executor ScrollUp

	public static void scrollUp(WebElement ref) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", ref);
	}

	// 42. Java Script Executor Click Method

	public static void javaScriptClick(WebElement ref) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ref);
	}

	// 43. Java Script Executor Passing Text/Values

	public static void javaScriptPassText(String value, WebElement ref) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + value + "')", ref);
	}

	// 44. Java Script Executor to retrieve the user Entered Text

	public static String javaScriptRetrieveText(WebElement ref) {

		js = (JavascriptExecutor) driver;
		Object retrieveText = js.executeScript("return arguments[0].getAttribute('value')", ref);
		String s = (String) retrieveText;
		System.out.println(s);
		return s;
	}

	// 45. Keyboard--Downkey

	public static void keyDown() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	// 46. Keyboard--Downkey

	public static void keyUp() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	// 47. Keyboard--Enter Key

	public static void enterKey() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	// 48. Keyboard--Ctrl + A (select all)

	public static void ctrlA() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_CONTROL);
	}

	// 49. Keyboard--Ctrl + X (cut)

	public static void ctrlX() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_X);
	}

	// 50. Keyboard--Ctrl + C (Copy)

	public static void ctrlC() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	// 51. Keyboard--Ctrl + V (Paste)

	public static void ctrlV() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	// 52. Keyboard--Tab

	public static void tabKey() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	public static void deleteKey() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_DELETE);
	}

	// 53. is selected--To check whether the Webelement is selected or not

	public static void isSelected(WebElement ref) {
		boolean sel = ref.isSelected();
		System.out.println(sel);
	}

	// 54. is enabled--To check whether the Webelement is enabled or not

	public static void isEnabled(WebElement ref) {
		boolean enable = ref.isEnabled();
		System.out.println(enable);
	}

	// 55. is enabled--To check whether the Webelement is displayed or not

	public static void isDisplayed(WebElement ref) {
		boolean display = ref.isDisplayed();
		System.out.println(display);
	}

	// 56. Get Text from Web Element

	public static String getText(WebElement ref) {
		String Text = ref.getText();
		System.out.println(Text);
		return Text;
	}

	// 57. Get Attribute (Corresponding Attribute Values)

	public static String getAttribute(WebElement ref, String attribute) {
		String val = ref.getAttribute(attribute);
		System.out.println(val);
		return val;
	}

	// 58. Get Attribute Value (USer entered value from Text Boxes)

	public static String getAttributeValue(WebElement ref) {
		String val = ref.getAttribute("value");
		return val;
	}

	// 59. Clear Textbox method

	public static void clearTextbox(WebElement ref) {
		ref.clear();
	}

	// 60. Submit Method

	public static void submitButton(WebElement ref) {
		ref.submit();
	}

	// 61. excelRead

	public static String excelRead(String fileName, String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("D:\\Booma\\Test\\MyClonnings\\JavaandFrameworkPrograms\\Excel\\" + fileName + ".xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		int cellType = cell.getCellType();

		// cellType == 1 --> String cell
		// cellType == 0 --> Date cell or Numeric Cell

		String value = "";

		if (cellType == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			value = sdf.format(dateCellValue);
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue; // downcasting
			value = String.valueOf(l);
		}
		return value;
	}

	// 62. Iterate all datas from excel

	public static void iterateExcelDatas(String fileName, String sheetName) throws IOException {
		File f = new File("D:\\Booma\\Test\\MyClonnings\\JavaandFrameworkPrograms\\Excel\\" + fileName + ".xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);

				int cellType = cell.getCellType();

				// cellType == 1 --> String cell
				// cellType == 0 --> Date cell or Numeric Cell

				String value = "";

				if (cellType == 1) {
					value = cell.getStringCellValue();
				} else if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					value = sdf.format(dateCellValue);
				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue; // downcasting
					value = String.valueOf(l);
				}
				System.out.println(value);
			}
		}
	}
	// 63. Total number of cells and rows

	public static void totalCellCount(String fileName, String sheetName) throws IOException {
		// 1. Excel sheet path

		File f = new File("D:\\Booma\\Test\\MyClonnings\\JavaandFrameworkPrograms\\Excel\\" + fileName + ".xlsx");

		// 2. Read the Excel file

		FileInputStream fis = new FileInputStream(f);

		// 3. Creating object for XSSF workbook to read .xlsx file format

		Workbook workbook = new XSSFWorkbook(fis);

		// 4. To get the sheet from the workbook

		Sheet sheet = workbook.getSheet(sheetName);

		// 5. Total number of rows

		int totalRows = sheet.getPhysicalNumberOfRows();

		System.out.println("The total number of rows are : " + totalRows);

		// 6. Total number of cells

		int count = 0;

		for (int i = 0; i < totalRows; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				row.getCell(j);
				count++;
			}
		}
		System.out.println("Total number of cells are : " + count);
	}

	// 64. Create Excel

	public static void createExcel(String excelFilePath, String sheetName) throws IOException {
		File f = new File(excelFilePath);
		Workbook workbook = new XSSFWorkbook();
		Sheet createSheet = workbook.createSheet(sheetName);

		FileOutputStream outputStream = new FileOutputStream(f);
		workbook.write(outputStream);
	}

	// 64. Create New Row

	public static void CreateRow(String excelFilePath, String sheetName, int rowNum) throws IOException {

		File f = new File(excelFilePath);
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNum);
		FileOutputStream outputStream = new FileOutputStream(f);
		workbook.write(outputStream);

	}

	// 65. Excel File Setup

	public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {

		File f = new File(excelFilePath);
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
	}

	// 66. Setting Cell Value

	public static void setCellValue(String excelFilePath, String sheetName, int rowNum, int cellNum, String cellValue)
			throws IOException {
		File f = new File(excelFilePath);
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.createCell(cellNum);
		cell.setCellValue(cellValue);
		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		workbook.write(outputStream);
	}

	// 67. getting Cell Value

	public static String getCellData(int rowNumber, int cellNumber) {
		// getting the cell value from rowNumber and cell Number
		row = sheet.getRow(rowNumber);
		cell = row.getCell(cellNumber);
		String stringCellValue = cell.getStringCellValue();
		// returning the cell value as string
		return stringCellValue;
	}

	// 68. getting Row count

	public static int getRowCountInSheet(String excelFilePath, String sheetName) throws IOException {
		File f = new File(excelFilePath);
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		return physicalNumberOfRows;
	}

	// 69. Firefox Browser Launch and Window Maximize

	public static void browserLaunchFirefox() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	// 70. Edge Browser Launch and Window Maximize

	public static void browserLaunchEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
}
