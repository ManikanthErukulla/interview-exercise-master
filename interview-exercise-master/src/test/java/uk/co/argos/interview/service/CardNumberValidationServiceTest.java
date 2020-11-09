package uk.co.argos.interview.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

class CardNumberValidationServiceTest {

    private static CardNumberValidationService cardNumberValidationService;

    @BeforeClass
    static void beforeAll() {
        cardNumberValidationService = new CardNumberValidationService();
    }
    

    @Test (dataProvider = "testData")
    static void testisNumeric(String test_data)
    {
    	Assert.assertTrue(cardNumberValidationService.isValid(test_data));
    }

    @DataProvider
    static Iterator<String> testData()
    {
    	ArrayList<String> al = new ArrayList<String>();
    	al.add("4242424242426742");  //valid card number
    	al.add("1234EFGH67891234"); //Non Numeric card number
    	al.add("424242424242674"); //Less size card number
    	al.add("424242424242674242"); //Greater size card number
    	al.add("1111111111111111"); //Correct size and format however invalid card number
    	al.add("9999999999999999"); //Correct size and format however invalid card number
    	
    	return al.iterator();

    }

    

}
