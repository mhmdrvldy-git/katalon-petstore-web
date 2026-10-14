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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import java.util.concurrent.ThreadLocalRandom

import com.kms.katalon.core.util.KeywordUtil

// Buat ID unik untuk pet
long petId = ThreadLocalRandom.current()
    .nextLong(1000000000L, 9000000000L)

// Kirim ID ke request object
def request = findTestObject(
    'API/Petstore/POST_Pet',
    [('petId'): petId.toString()]
)

def response = WS.sendRequest(request)

// Validasi response
WS.verifyResponseStatusCode(response, 200)

def responseBody = new JsonSlurper().parseText(
    response.getResponseBodyContent()
)

assert responseBody.id.toString() == petId.toString()
assert responseBody.name == 'KatalonPet'
assert responseBody.status == 'available'

// Simpan ID yang benar-benar dikembalikan API
def createdPetId = responseBody.id

println("DEBUG responseBody.id = " + responseBody.id)
println("DEBUG createdPetId = " + createdPetId)
println("DEBUG class = " + createdPetId?.getClass()?.getName())