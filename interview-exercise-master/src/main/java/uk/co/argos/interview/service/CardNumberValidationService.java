package uk.co.argos.interview.service;

public class CardNumberValidationService {

    /**
     * 1. From the last digit moving backwards, double every second digit
     * 2. If the doubled number is greater than 9, add it's two digits together
     * 3. Sum all card digits together
     * 4. If the total ends in zero, then the number is a valid credit card
     */
	
/*
 * The below function performs the test as stated above and also
 * checks if the card is numeric 
 * and if the card length is always 16 digits. 
 * 
 */

    public boolean isValid(String cardNumber) {
    	
    	if (cardNumber.length()==16)
    	{
    		try {
    			Double.parseDouble(cardNumber);
    		}
    		catch (NumberFormatException e){
    			System.out.println(cardNumber+" Card Number should be Numeric");
    			return false;
    		}
        	int sum = 0;
        	for(int i=cardNumber.length()-1;i>=0;i--)
        	{
        		int num=Integer.parseInt(String.valueOf(cardNumber.charAt(i))); 
        		
        		if(i%2 == 0)
        		{
        			num = num*2;
        			if(num > 9)
        			{
        				int sum_temp = 0;
        				while(num > 0)
        				{
        					sum_temp = sum_temp + num%10;
        					num = num/10;
        				}
        				sum = sum+sum_temp; 
        			}
        			else
        				sum = sum+num;
        		}
        		else
        			sum = sum + num;
        	}
        	if(sum%10 == 0)
        		return true;
        	else
        		System.out.println(cardNumber+" Card Number format is valid but the card number is invalid");
        		return false;
    	}
    	else
    		System.out.println(cardNumber+" Invalid Card Length");
    		return false;
    }

}
