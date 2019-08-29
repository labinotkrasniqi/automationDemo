
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import java.lang.Integer


def static "b2b.utilities.Navigation.refreshBrowser"() {
    (new b2b.utilities.Navigation()).refreshBrowser()
}

def static "b2b.utilities.Navigation.clickElement"(
    	TestObject to	) {
    (new b2b.utilities.Navigation()).clickElement(
        	to)
}

def static "b2b.utilities.Navigation.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new b2b.utilities.Navigation()).getHtmlTableRows(
        	table
         , 	outerTagName)
}

def static "b2b.utilities.Navigation.OpenBrowser"(
    	String url	) {
    (new b2b.utilities.Navigation()).OpenBrowser(
        	url)
}

def static "b2b.utilities.OtherUtilities.randomStringGenerator"(
    	Integer stringLength	
     , 	String type	) {
    (new b2b.utilities.OtherUtilities()).randomStringGenerator(
        	stringLength
         , 	type)
}
