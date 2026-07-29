import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser(null)

WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.setText(findTestObject('Login/input_Username'), 'standard_user')

WebUI.setEncryptedText(findTestObject('Login/input_Password'), 'qcu24s4901FyWDTwXGr6XA==')

String inputType = WebUI.getAttribute(findTestObject('Login/input_Password'), 'type')
WebUI.verifyMatch(inputType, 'password', false)

WebUI.closeBrowser()
