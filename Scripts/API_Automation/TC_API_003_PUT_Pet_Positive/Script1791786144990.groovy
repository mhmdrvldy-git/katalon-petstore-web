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

// 1. Generate ID
long petId = ThreadLocalRandom.current()
	.nextLong(1000000000L, 9000000000L)

// 2. Create pet terlebih dahulu
def postRequest = findTestObject(
	'API/Petstore/POST_Pet',
	[('petId'): petId.toString()]
)

def postResponse = WS.sendRequest(postRequest)
WS.verifyResponseStatusCode(postResponse, 200)

def createdPet = new JsonSlurper().parseText(
	postResponse.getResponseBodyContent()
)

assert createdPet.id.toString() == petId.toString()

// 3. Update pet
def putRequest = findTestObject(
	'API/Petstore/PUT_Pet',
	[('petId'): petId.toString()]
)

def putResponse = WS.sendRequest(putRequest)
WS.verifyResponseStatusCode(putResponse, 200)

def updatedPet = new JsonSlurper().parseText(
	putResponse.getResponseBodyContent()
)

// 4. Validate update
assert updatedPet.id.toString() == petId.toString()
assert updatedPet.name == 'KatalonPetUpdated'
assert updatedPet.status == 'sold'

println('PUT Positive Passed. Pet ID: ' + petId)
println('Updated name: ' + updatedPet.name)
println('Updated status: ' + updatedPet.status)