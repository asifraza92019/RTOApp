package com.nit.generator;

import java.util.Random;

public class RegistrationNumber {

	public String generateRegistrationNumber()
	{
	       Random rand = new Random();  
	        int rand_int2 = rand.nextInt(10);
	         System.out.println(rand_int2);
	         String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	         String randomString = "";
	         int length = 3;
	         char [] text = new char [length];
	         for(int i=0; i<length; i++)
	         {
	         	text[i] = characters.charAt(rand.nextInt(characters.length()));
	         }
	         
	         for(int i = 0 ; i<text.length; i++)
	          {
	          	randomString+= text[i];
	            }
	         System.out.println(randomString);
             int rand_int1= rand.nextInt(1000); 
            System.out.println(rand_int1);
	               String vehicleRegistrationNumber = rand_int2+ randomString+rand_int1;
	               System.out.println(vehicleRegistrationNumber);
		         return vehicleRegistrationNumber;
	      	
	}
	
	
}
