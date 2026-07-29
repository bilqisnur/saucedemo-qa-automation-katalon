import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

WebUI.callTestCase(findTestCase('LOGIN/TC_Login_01_ValidCredentials'), [:], FailureHandling.STOP_ON_FAILURE)

// Step 1: Pilih sorting Price (low to high)
WebUI.selectOptionByLabel(findTestObject('Catalog/sortin_products'), 'Price (low to high)', false)

// Step 2: Refresh halaman
WebUI.refresh()

// Step 3: Ambil elemen dropdown pakai Selenium native, cek opsi yang lagi kepilih
WebElement dropdownElement = WebUI.findWebElement(findTestObject('Catalog/sortin_products'), 10)
Select select = new Select(dropdownElement)
String currentSortValue = select.getFirstSelectedOption().getText()

WebUI.verifyEqual(currentSortValue, 'Name (A to Z)')

// Step 4: Verifikasi urutan produk juga kembali alfabetis (default)
List<WebElement> productNames = WebUI.findWebElements(findTestObject('Catalog/item_name'), 10)

List<String> actualNames = []
for (WebElement element : productNames) {
    actualNames.add(element.getText())
}

List<String> expectedDefaultOrder = new ArrayList<>(actualNames)
Collections.sort(expectedDefaultOrder)

WebUI.verifyEqual(actualNames, expectedDefaultOrder)

WebUI.closeBrowser()