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


import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as OR

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

// Buka website
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl(GlobalVariable.baseUrl)

// Buka halaman login
WebUI.click(findTestObject('Web/Login/lnk_SignIn'))
WebUI.waitForPageLoad(10)

// Isi data dari Excel
WebUI.setText(
	findTestObject('Web/Login/txt_UserID'),
	username
)

WebUI.setText(
	findTestObject('Web/Login/txt_Password'),
	password
)

// Klik login
WebUI.click(findTestObject('Web/Login/btn_Login'))
WebUI.waitForPageLoad(10)

// Validasi berdasarkan expectedResult
if (expectedResult.equalsIgnoreCase('success')) {

	WebUI.verifyElementPresent(
		findTestObject('Web/Login/lnk_SignOut'),
		10
	)

} else {

	// Untuk data login gagal, pastikan menu Sign Out tidak muncul
	WebUI.verifyElementNotPresent(
		findTestObject('Web/Login/lnk_SignOut'),
		5
	)
}

WebUI.closeBrowser()
