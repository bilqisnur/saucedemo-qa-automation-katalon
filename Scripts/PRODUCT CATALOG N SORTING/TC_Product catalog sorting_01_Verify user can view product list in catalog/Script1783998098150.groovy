import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement

WebUI.callTestCase(findTestCase('Test Cases/LOGIN/TC_Login_01_ValidCredentials'), [:], FailureHandling.STOP_ON_FAILURE)

// Step 2: Verifikasi produk-produk muncul (minimal beberapa elemen kunci)
WebUI.verifyElementPresent(findTestObject('Object Repository/Catalog/titleProduct1'), 5)
WebUI.verifyElementPresent(findTestObject('Object Repository/Catalog/productPrice1'), 5)
WebUI.verifyElementPresent(findTestObject('Object Repository/Catalog/img_product1'), 5)
WebUI.verifyElementPresent(findTestObject('Object Repository/Catalog/btn_add to cart'), 5)

// Step 3: Verifikasi jumlah produk yang tampil (harus 6 di SauceDemo)
List<WebElement> products = WebUI.findWebElements(findTestObject('Catalog/productListPage'), 10)
WebUI.verifyEqual(products.size(), 6)
// ATAU pakai findWebElements untuk hitung manual

// Step 4: Verifikasi nama produk spesifik (data check)
WebUI.verifyElementText(findTestObject('Object Repository/Catalog/titleProduct1'), 'Sauce Labs Backpack')

WebUI.closeBrowser()