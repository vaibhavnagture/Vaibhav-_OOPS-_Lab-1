package com.greatlearning;

import java.util.Stack;




public class BalancingBrackets {
	
	static boolean chekingBracketsBalanced( String bracketExpression)

	{
		//function  to chek if brackets are balanced
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < bracketExpression.length(); i++)
			
		{
			char character = bracketExpression.charAt(i);
			
			if (character == '(' || character == '[' || character == '{' )
			{
				
				stack.push(character);
				continue;
			}
			if (stack.isEmpty())
				return false;
			
			char c;
			
			switch (character) {
			
			case '}':
				
				c = stack.pop();
				if(c== '(' || c == '[')
					return false;
				break;
				
			case']':
				c = stack.pop();
				if (c == '(' || c == '{')
					return false;
				break;
			}
		}
		return (stack.isEmpty());
	}

}
					
					
			
			 
			
			
			
			
		
