package com.greatlearning;

public class Driver {

	public static void main(String[] args) 
	
	{
		String bracketExpression = "([[{}]]) ";
		
		Boolean result ;
		
		result = checkingBracketsBalanced(bracketExpression);
		
		if (result)
			System.out.println(" The entered String has Balanced Brackets");
		else
			
			System.out.println(" The entered String do not contai Balanced Brackets");

	}

}
