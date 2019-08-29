package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object baseUrl
     
    /**
     * <p></p>
     */
    public static Object memberUsername
     
    /**
     * <p></p>
     */
    public static Object memberPassword
     
    /**
     * <p></p>
     */
    public static Object waitShort
     
    /**
     * <p></p>
     */
    public static Object waitNormal
     
    /**
     * <p></p>
     */
    public static Object waitLong
     
    /**
     * <p></p>
     */
    public static Object secondUrl
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            baseUrl = selectedVariables['baseUrl']
            memberUsername = selectedVariables['memberUsername']
            memberPassword = selectedVariables['memberPassword']
            waitShort = selectedVariables['waitShort']
            waitNormal = selectedVariables['waitNormal']
            waitLong = selectedVariables['waitLong']
            secondUrl = selectedVariables['secondUrl']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
