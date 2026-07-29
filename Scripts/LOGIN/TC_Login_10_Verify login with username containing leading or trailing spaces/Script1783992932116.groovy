import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser(null)

WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.setText(findTestObject('Login/input_Username'), ' standard_user')

WebUI.setEncryptedText(findTestObject('Login/input_Password'), 'qcu24s4901FyWDTwXGr6XA==')

WebUI.click(findTestObject('Login/btn_login'))

WebUI.verifyMatch(WebUI.getText(findTestObject('Login/lbl_ErrorMessage')),'.*Username and password do not match any user in this service.*',true)

WebUI.closeBrowser()