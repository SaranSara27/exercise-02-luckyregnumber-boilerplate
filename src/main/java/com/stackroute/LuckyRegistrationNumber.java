package com.stackroute;

import java.util.Scanner;

//Complete the code below as given in the problem.md file
public class LuckyRegistrationNumber {

   
    public static int checkRegistrationNumber(String regNumber) {
    	String regex = "(KA|DL)(0[1-9]|10)[A-Z]{1,2}[1-9][0-9]{3}";
    	int output = -1;
    	if (regNumber.matches(regex))
    		output = 0;
    	if (output == 0) {
    		int num = Integer.valueOf(regNumber.substring(regNumber.length() - 4));
    		int sum = sumOfDigits(num);
    		if (sum > 9)
    			sum = sumOfDigits(sum);
    		if (sum == 6)
    			output = 1;
    	}
    	return output;
    }
    
    private static int sumOfDigits(int num) {
		int sum = 0;
		while (num != 0) {
			sum = sum + num % 10;
			num = num / 10;
		}
		return sum;
	}

   	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
    	//Use Scanner to get input from console
    	Scanner scanner = new Scanner(System.in);
    	String regNumber = scanner.nextLine();
    	int output = checkRegistrationNumber(regNumber);
    	if (output == 1)
    		System.out.println("Lucky Registration Number");
    	else if (output == 0)
    		System.out.println("Valid Registration Number");
    	else if (output == -1)
    		System.out.println("Invalid Registration Number");
 
    
    }

}