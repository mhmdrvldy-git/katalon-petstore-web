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
import org.openqa.selenium.By
import java.util.UUID


import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as OR
import java.util.UUID

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

// Dynamic data
String suffix = UUID.randomUUID().toString().replace('-', '').substring(0, 8)
String username = 'Rivaldy' + suffix
String password = 'QaTest123!'
String email = 'qa_' + suffix + '@example.com'

// Buka halaman registrasi


WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.baseUrl)
WebUI.maximizeWindow()

WebUI.click(OR.findTestObject('Web/Login/lnk_SignIn'))
WebUI.waitForPageLoad(10)
WebUI.click(OR.findTestObject('Web/Register/lnk_RegisterNow'))
WebUI.waitForPageLoad(10)

// Isi User Information
WebUI.setText(OR.findTestObject('Web/Register/txt_UserID'), username)
WebUI.setText(OR.findTestObject('Web/Register/txt_Password'), password)
WebUI.setText(OR.findTestObject('Web/Register/txt_RepeatPassword'), password)

// Isi Account Information
WebUI.setText(OR.findTestObject('Web/Register/txt_FirstName'), 'Rivaldy')
WebUI.setText(OR.findTestObject('Web/Register/txt_LastName'), 'Automation')
WebUI.setText(OR.findTestObject('Web/Register/txt_Email'), email)
WebUI.setText(OR.findTestObject('Web/Register/txt_Phone'), '081234567890')
WebUI.setText(OR.findTestObject('Web/Register/txt_Address1'), 'Jl. Merdeka No. 10')
WebUI.setText(OR.findTestObject('Web/Register/txt_Address2'), 'RT 01 RW 02')
WebUI.setText(OR.findTestObject('Web/Register/txt_City'), 'Bogor')
WebUI.setText(OR.findTestObject('Web/Register/txt_State'), 'Jawa Barat')
WebUI.setText(OR.findTestObject('Web/Register/txt_Zip'), '16111')
WebUI.setText(OR.findTestObject('Web/Register/txt_Country'), 'Indonesia')

// Isi Profile Information
WebUI.selectOptionByLabel(
    OR.findTestObject('Web/Register/ddl_Language'),
    'english',
    false
)

WebUI.selectOptionByLabel(
    OR.findTestObject('Web/Register/ddl_FavouriteCategory'),
    'FISH',
    false
)

// Aktifkan checkbox jika belum tercentang
if (!WebUI.verifyElementChecked(
    OR.findTestObject('Web/Register/chk_EnableMyList'), 2,
    com.kms.katalon.core.model.FailureHandling.OPTIONAL
)) {
    WebUI.check(OR.findTestObject('Web/Register/chk_EnableMyList'))
}

if (!WebUI.verifyElementChecked(
    OR.findTestObject('Web/Register/chk_EnableMyBanner'), 2,
    com.kms.katalon.core.model.FailureHandling.OPTIONAL
)) {
    WebUI.check(OR.findTestObject('Web/Register/chk_EnableMyBanner'))
}

// Simpan akun
WebUI.click(OR.findTestObject('Web/Register/btn_SaveAccount'))
WebUI.waitForPageLoad(10)

// Validasi awal: tampilkan URL hasil setelah penyimpanan
WebUI.comment('Username yang didaftarkan: ' + username)
WebUI.comment('Email yang digunakan: ' + email)
WebUI.comment('URL setelah submit: ' + WebUI.getUrl())

WebUI.closeBrowser()
