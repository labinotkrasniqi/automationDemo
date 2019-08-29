import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.testng.asserts.Assertion

import com.kms.katalon.core.util.KeywordUtil

	def productNumber = '3887121'
	def FirstName = 'John'
	def LastName = 'Doe'
	def address = 'Alabama Street'
	def city = 'Alabama'
	def visaCardNumber = '4111111111111111'
	def expireDate = '1224'
	def securityCode = '900'
	
	CustomKeywords.'b2b.utilities.Navigation.OpenBrowser'(GlobalVariable.baseUrl)
	//WebUI.click(findTestObject('Object Repository/button_AcceptCookies'))
	Login(GlobalVariable.memberUsername, GlobalVariable.memberPassword)
	WebUI.setText(findTestObject('Object Repository/input_Search'),productNumber, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.sendKeys(findTestObject('Object Repository/input_Search'), Keys.chord(Keys.ENTER))
	WebUI.click(findTestObject('Object Repository/button_AddToCart'))
	WebUI.click(findTestObject('Object Repository/a_ConfirmAddToCart'))
	WebUI.click(findTestObject('Object Repository/button_Check Out'))
	
	WebUI.comment('Fill the shipping address information')
	WebUI.click(findTestObject('Object Repository/Checkout/button_NextPaymentType'))
	//WebUI.click(findTestObject('Object Repository/Checkout/button_NextBilling'))
	//WebUI.verifyElementText(findTestObject('Object Repository/Checkout/button_NextBilling'), visaCardNumber, FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.selectOptionByValue(findTestObject('Object Repository/Checkout/select_Country'), 'AL', false, FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.delay(1)
//	WebUI.selectOptionByValue(findTestObject('Object Repository/Checkout/select_title'), 'mr', false, FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.setText(findTestObject('Object Repository/Checkout/input_FirstName'), FirstName,FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.setText(findTestObject('Object Repository/Checkout/input_LastName'), LastName, FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.setText(findTestObject('Object Repository/Checkout/input_AddressLine'),address, FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.setText(findTestObject('Object Repository/Checkout/input_City'), city, FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.setText(findTestObject('Object Repository/Checkout/input_PostCode'),LastName, FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.check(findTestObject('Object Repository/Checkout/input_SaveShippingAddress'), FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.click(findTestObject('Checkout/button_NextShipmentAddress'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.waitForElementPresent(findTestObject('Object Repository/Checkout/select_ShipmentMethod'),GlobalVariable.waitNormal, FailureHandling.CONTINUE_ON_FAILURE)
	def shipmentMethodValue  = WebUI.getText(findTestObject('Object Repository/Checkout/select_ShipmentMethod'))
	if(shipmentMethodValue.equals(' ')){
		KeywordUtil.markFailedAndStop('User cannot select a shipment method, because the shipment method has no value')
	}
	else{
		KeywordUtil.markPassed('Shipment method has a value')
	}
	WebUI.click(findTestObject('Checkout/button_NextShippingMethod'))
	WebUI.selectOptionByIndex(findTestObject('Checkout/select_PaymentMethod'), 1, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Checkout/button_NextBilling'))
	
	def orderTotal = WebUI.getText(findTestObject('Checkout/div_OrderTotal'), FailureHandling.CONTINUE_ON_FAILURE)
	def orderRightSide = WebUI.getText(findTestObject('Checkout/div_OrderTotal-RightSideBar'))
	WebUI.verifyEqual(orderTotal, orderRightSide, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.click(findTestObject('Checkout/input_TermsConditions'))
	WebUI.click(findTestObject('Checkout/button_PlaceOrder'))
	
	WebUI.delay(2)
	
	WebUI.switchToFrame(findTestObject('Object Repository/Checkout/iframe_Final Review_paymentForm_4129'), 30, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.setText(findTestObject('Checkout/input_CardHolderName'), FirstName, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.setText(findTestObject('Checkout/input_CardNumber'), visaCardNumber, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.setText(findTestObject('Checkout/div_ExpireDate'), expireDate, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.setText(findTestObject('Checkout/input_SecurityCode'), securityCode, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Checkout/button_Paynow'))
	
	
	
	
	//Methods
		def  Login(String username, String password){
	
		WebUI.click(findTestObject('Object Repository/a_SignInRegister'))
		WebUI.setText(findTestObject('Object Repository/input_EmailAddress'),username, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.setText(findTestObject('Object Repository/input_UserPassword'),password, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/button_LogIn'))
		//WebUI.verifyTextPresent('WELCOME JOHN', false, FailureHandling.CONTINUE_ON_FAILURE)
}