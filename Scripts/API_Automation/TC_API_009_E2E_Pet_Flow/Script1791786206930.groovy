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
import java.util.concurrent.ThreadLocalRandom
import com.kms.katalon.core.util.KeywordUtil

def petId = ThreadLocalRandom.current()
	.nextLong(1000000000L, 9000000000L)

def slurper = new JsonSlurper()

// 1. POST: buat pet
def postRequest = findTestObject(
	'API/Petstore/POST_Pet',
	[('petId'): petId.toString()]
)

def postResponse = WS.sendRequest(postRequest)
WS.verifyResponseStatusCode(postResponse, 200)

def createdPet = slurper.parseText(
	postResponse.getResponseBodyContent()
)

assert createdPet.id.toString() == petId.toString()
KeywordUtil.logInfo('POST berhasil. Pet ID: ' + petId)

// 2. PUT: update pet yang sama
def putRequest = findTestObject(
	'API/Petstore/PUT_Pet',
	[('petId'): petId.toString()]
)

def putResponse = WS.sendRequest(putRequest)
WS.verifyResponseStatusCode(putResponse, 200)

KeywordUtil.logInfo('PUT berhasil untuk Pet ID: ' + petId)

// 4. GET: verifikasi data pet yang sudah di-update
def getRequest = findTestObject(
	'API/Petstore/GET_Pet_ById',
	[('petId'): petId.toString()]
)

def getResponse = WS.sendRequest(getRequest)
WS.verifyResponseStatusCode(getResponse, 200)

def fetchedPet = new JsonSlurper().parseText(
	getResponse.getResponseBodyContent()
)

assert fetchedPet.id.toString() == petId.toString()
assert fetchedPet.name == 'KatalonPetUpdated'
assert fetchedPet.status == 'sold'

println("GET berhasil. Pet ID: " + petId)
println("Nama terbaru: " + fetchedPet.name)


// 5. DELETE: hapus pet yang dibuat oleh test
def deleteRequest = findTestObject(
	'API/Petstore/DELETE_Pet_ById',
	[('petId'): petId.toString()]
)

def deleteResponse = WS.sendRequest(deleteRequest)

def verifyDeleteRequest = findTestObject(
	'API/Petstore/GET_Pet_ById',
	[('petId'): petId.toString()]
)

def verifyDeleteResponse = WS.sendRequest(verifyDeleteRequest)

println(
	"GET setelah DELETE: HTTP " +
	verifyDeleteResponse.getStatusCode()
)

// Status aktual harus diperiksa sesuai respons API
WS.verifyResponseStatusCode(deleteResponse, 200)

println("DELETE response status: " + deleteResponse.getStatusCode())