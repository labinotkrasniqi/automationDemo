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
	import com.kms.katalon.core.util.KeywordUtil
	import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
	import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
	import internal.GlobalVariable as GlobalVariable
	import b2b.utilities.OtherUtilities
	
	def username = 'admin'
	def password = '19ax74ue_'
	def name = CustomKeywords.'b2b.utilities.OtherUtilities.randomStringGenerator'(5, OtherUtilities.RANDOM_ALPHANUM)
	def pageLabel = CustomKeywords.'b2b.utilities.OtherUtilities.randomStringGenerator'(5, OtherUtilities.RANDOM_ALPHANUM)
	def pageTitle = CustomKeywords.'b2b.utilities.OtherUtilities.randomStringGenerator'(5, OtherUtilities.RANDOM_ALPHANUM)
	
	
	CustomKeywords.'b2b.utilities.Navigation.OpenBrowser'(GlobalVariable.secondUrl)
	
	WebUI.setText(findTestObject('Object Repository/Page_SmartEdit/Page_/input_smartEditUsername'),username, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.setText(findTestObject('Object Repository/Page_SmartEdit/Page_/input_SmartEditPassword'), password, FailureHandling.CONTINUE_ON_FAILURE)
	//WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_SmartEdit/Page_/span_SelectALanguage'),3, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_SmartEdit/Page_/button_Sign in'))
	
	WebUI.click(findTestObject('Object Repository/Page_SmartEdit/a_Pages'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_SmartEdit/button_AddNewPage'))
	WebUI.click(findTestObject('Object Repository/Page_SmartEdit/div_ContentPage'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_SmartEdit/button_Next'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_SmartEdit/div_LandingPage2Template'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_SmartEdit/button_Next'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Page_SmartEdit/button_Next'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.setText(findTestObject('Object Repository/Page_SmartEdit/input_Name'), name, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.setText(findTestObject('Object Repository/Page_SmartEdit/input_PageLabel'),pageLabel, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.setText(findTestObject('Object Repository/Page_SmartEdit/input_EN_title'),pageTitle, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.click(findTestObject('Object Repository/Page_SmartEdit/button_Done'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(GlobalVariable.waitNormal)
	