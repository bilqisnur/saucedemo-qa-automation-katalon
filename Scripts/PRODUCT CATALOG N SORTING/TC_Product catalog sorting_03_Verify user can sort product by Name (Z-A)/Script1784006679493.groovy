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


WebUI.callTestCase(findTestCase('LOGIN/TC_Login_01_ValidCredentials'), [:], FailureHandling.STOP_ON_FAILURE)

// Step 2: Verifikasi produk-produk muncul (minimal beberapa elemen kunci)
WebUI.selectOptionByLabel(findTestObject('Catalog/sortin_products'), 'Name (Z to A)', false)


// Ambil semua elemen nama produk
List<WebElement> productNames = WebUI.findWebElements(findTestObject('Catalog/item_name'), 10)

// Ambil teks dari tiap elemen, masukkan ke List<String>
List<String> actualNames = []
for (WebElement element : productNames) {
	actualNames.add(element.getText())
}

// Buat salinan list, lalu sort manual pakai Groovy buat jadi pembanding
List<String> expectedSortedNames = new ArrayList<>(actualNames)
Collections.sort(expectedSortedNames, Collections.reverseOrder())

// Bandingkan apakah urutan aktual sama dengan urutan yang sudah di-sort
WebUI.verifyEqual(actualNames, expectedSortedNames)

WebUI.closeBrowser()