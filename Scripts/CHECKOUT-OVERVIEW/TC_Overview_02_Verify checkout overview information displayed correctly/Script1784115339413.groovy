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

WebUI.callTestCase(findTestCase('CHECKOUT-OVERVIEW/TC_Overview_01_Verify user can proceed to checkout overview page'),
	[:], FailureHandling.STOP_ON_FAILURE)

// Verifikasi detail produk
WebUI.verifyElementText(findTestObject('Checkout_overview/lbl_titleproduct'), 'Sauce Labs Backpack')
WebUI.verifyElementText(findTestObject('Checkout_overview/price_product'), '$29.99')

// Verifikasi rincian harga
WebUI.verifyElementPresent(findTestObject('Checkout_overview/item_total'), 5)
WebUI.verifyElementPresent(findTestObject('Checkout_overview/tax_price'), 5)
WebUI.verifyElementPresent(findTestObject('Checkout_overview/total_pay'), 5)

// Validasi perhitungan: Total = Item Total + Tax
String itemTotalText = WebUI.getText(findTestObject('Checkout_overview/item_total')).replace('Item total: \$', '')
String taxText = WebUI.getText(findTestObject('Checkout_overview/tax_price')).replace('Tax: \$', '')
String totalText = WebUI.getText(findTestObject('Checkout_overview/total_pay')).replace('Total: \$', '')

double itemTotal = Double.parseDouble(itemTotalText)
double tax = Double.parseDouble(taxText)
double total = Double.parseDouble(totalText)

WebUI.verifyEqual(total, itemTotal + tax)

WebUI.closeBrowser()
