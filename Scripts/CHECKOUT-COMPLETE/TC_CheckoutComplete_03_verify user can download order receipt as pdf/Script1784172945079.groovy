import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


WebUI.callTestCase(findTestCase('CHECKOUT-OVERVIEW/TC_Overview_01_Verify user can proceed to checkout overview page'),
	[:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Checkout_overview/btn_finish'))


// Bersihkan dulu folder Downloads dari file PDF lama (biar gak ketuker)
String downloadPath = System.getProperty('user.home') + '/Downloads'
File downloadFolder = new File(downloadPath)
downloadFolder.listFiles().each { file ->
	if (file.name.startsWith('swag-labs-order-') && file.name.endsWith('.pdf')) {
		file.delete()
	}
}


WebUI.click(findTestObject('Checkout_Complete/btn_generatePDF'))

// Verifikasi loading state muncul (tombol berubah jadi "Generating...")
WebUI.verifyElementText(findTestObject('Checkout_Complete/btn_generatePDF'), 'Generating...')

WebUI.delay(20)

// Cek apakah ada file PDF baru dengan pattern nama yang sesuai
File[] matchingFiles = downloadFolder.listFiles({ dir, name ->
	name.startsWith('swag-labs-order-') && name.endsWith('.pdf')
} as FilenameFilter)

assert matchingFiles.length > 0 : "File PDF tidak ditemukan di folder Downloads"
assert matchingFiles[0].length() > 0 : "File PDF ter-download tapi ukurannya 0 byte"

WebUI.closeBrowser()
