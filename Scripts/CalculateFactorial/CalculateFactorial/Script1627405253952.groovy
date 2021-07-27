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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ConditionType


WebUI.openBrowser("http://192.168.1.104:6464/")

if(WebUI.waitForElementPresent(findTestObject("Object Repository/CalculateFactorial_Elements/input_ factorial calculator_number"), 10)){

	WebUI.setText(findTestObject("Object Repository/CalculateFactorial_Elements/input_ factorial calculator_number"), "20")
	if(WebUI.sendKeys(findTestObject("Object Repository/CalculateFactorial_Elements/input_ factorial calculator_number"), Keys.chord(Keys.ENTER))){
		WebUI.sendKeys(findTestObject("Object Repository/CalculateFactorial_Elements/input_ factorial calculator_number"), Keys.chord(Keys.ENTER))
	}else {
		KeywordUtil.markError("El elememnto no se le puede dar enter")
		if(WebUI.waitForElementPresent(findTestObject("Object Repository/CalculateFactorial_Elements/button_Calculate"), 10)){
			WebUI.click(findTestObject("Object Repository/CalculateFactorial_Elements/button_Calculate"))
		}
	}
	String resultado = "2432902008176640000"
	
	String xpath = "//p[text()[contains(.,'The factorial of 20 is: '"+resultado+"'')]]"
	TestObject obj = new TestObject(xpath)
	obj.addProperty("xpath", ConditionType.EQUALS,xpath )
	if(obj) {
		KeywordUtil.markPassed("El resultado es correcto")
	}else {
		KeywordUtil.markError("El resultado es incorrecto.")

	}

}else {
	KeywordUtil.markError("El elememnto no pudo ser encontrado")
}





