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

WebUI.openBrowser(null)
WebUI.callTestCase(findTestCase('LOGIN/TC_Login_01_ValidCredentials'), [:], FailureHandling.STOP_ON_FAILURE)

// Step 1: Simpan nama produk yang mau di-add (buat verifikasi nanti)
String expectedProductName = WebUI.getText(findTestObject('Catalog/titleProduct1'))

// Step 2: Add produk ke cart dari halaman Catalog
WebUI.click(findTestObject('Catalog/btn_add to cart'))

// Step 3: Verifikasi badge cart = 1
WebUI.verifyElementText(findTestObject('ProductDetail/shoppingCart'), '1')

// Step 4: Navigasi ke Product Detail page (produk lain, misal produk ke-2)
WebUI.click(findTestObject('Catalog/titleProduct2'))

// Step 5: Verifikasi badge cart TETAP 1 (gak hilang meskipun pindah halaman)
WebUI.verifyElementText(findTestObject('ProductDetail/shoppingCart'), '1')

// Step 6: Kembali ke halaman Catalog
WebUI.click(findTestObject('ProductDetail/Btn_back'))

// Step 7: Verifikasi badge cart MASIH 1 setelah kembali
WebUI.verifyElementText(findTestObject('ProductDetail/shoppingCart'), '1')

// Step 8: Masuk ke halaman Cart, verifikasi produk yang di-add masih ada dan sesuai
WebUI.click(findTestObject('Cart/icon_cart'))
WebUI.verifyElementText(findTestObject('Cart/lbl_product'), expectedProductName)

WebUI.closeBrowser()