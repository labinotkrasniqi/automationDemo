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

	String memberUsername = GlobalVariable.memberUsername
	
	CustomKeywords.'b2b.utilities.Navigation.OpenBrowser'(GlobalVariable.baseUrl)
	//WebUI.click(findTestObject('Object Repository/button_AcceptCookies'))
	Login(GlobalVariable.memberUsername, GlobalVariable.memberPassword)
	
	String usernameLabel =WebUI.getText(findTestObject('Object Repository/Page_SmartEdit/Page_Powertools Site  Homepage/li_WelcomeLabel') , FailureHandling.CONTINUE_ON_FAILURE)
	println(usernameLabel)
	if(usernameLabel.contentEquals('WELCOME MARK')){
		
	KeywordUtil.markPassed('Username is shown on the landing page after Log In')	
	}
	
	else{
	
		KeywordUtil.markFailedAndStop('Username not found on the landing page')	
	}
	



		//Methods
		def  Login(String username, String password){
		
		WebUI.click(findTestObject('Object Repository/a_SignInRegister'))
		WebUI.setText(findTestObject('Object Repository/input_EmailAddress'),username, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.setText(findTestObject('Object Repository/input_UserPassword'),password, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/button_LogIn'))
		
		}