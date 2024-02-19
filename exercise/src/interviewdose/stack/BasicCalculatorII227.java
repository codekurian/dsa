package interviewdose.stack;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/basic-calculator-ii/description/
public class BasicCalculatorII227 {

	public static void main(String[] args) {
		//System.out.println(calculate("0-2147483647"));

	}
/*
	  public static int calculate(String s) {

			char[] inputArray = s.trim().toCharArray();
			
			Stack<String> expressionStack = new Stack<>();
			List<String> expressionList = new ArrayList<>();

			for (int i = 0; i < inputArray.length; i++) {
				Integer currentNumber = 0;
				char c = inputArray[i];
				if (Character.isDigit(c)) {
					while (i < inputArray.length && Character.isDigit(inputArray[i])) {
						currentNumber = (currentNumber * 10) + (inputArray[i] - '0');
						i++;
					}
					expressionList.add(currentNumber.toString());
					i = i - 1;

				} else if (!Character.isWhitespace(c) && !Character.isDigit(c)) {
					// this is a non digit character which has to be processed
					
					// if we get closing braces pop until we get opening braces
					if(c== ')') {
						while (!expressionStack.isEmpty() && !expressionStack.peek().equals("(")) {
							expressionList.add(expressionStack.pop());
						}
						if(!expressionStack.isEmpty()) {
							expressionStack.pop();
						}
						

					}
					if(c== '(') {
						expressionStack.push(c + "");

					}
					if(c== '+') {
						populateExpressionList(expressionStack, expressionList, c);
						

					}
					if(c== '-'){
						populateExpressionList(expressionStack, expressionList, c);
						

					}

					
					
				

				}

				
			}
			while(!expressionStack.isEmpty()) {
				expressionList.add(expressionStack.pop());
			}
			return evaluatePostfix(expressionList);
		}
	  
	 static int evaluate(int a,int b , Character operand) {
		  
		  
		  if(operand=='+') {
			  return a+b;
		  }else if(operand=='-') {
			  return b-a;
		  }else if(operand=='*') {
			  return a*b;
		  }else if(operand=='/') {
			  return b/a;
		  }else return -1;
	  }
	 
	 static void addToPostfixExpression(Character incomingChar,Stack<Character> postfixStack,List<Character>  expressionEvalStack) {
		 
		 if(!postfixStack.isEmpty()) {
			 Character topOfTheStack = postfixStack.peek();
			 int precedenceIcomingChar =  getPrecedenceValue(incomingChar);
			 int precedenceTopOfTheStack =  getPrecedenceValue(topOfTheStack);
			 if(postfixStack.isEmpty()||precedenceIcomingChar>precedenceTopOfTheStack) {
				 postfixStack.push(incomingChar);
			 }else {
				 while(getPrecedenceValue(postfixStack.peek())>=incomingChar){
					 Character popped  = postfixStack.pop();
					 expressionEvalStack.add(popped);
				 }
				 expressionEvalStack.add(incomingChar);
			 }
		 }else {
			 postfixStack.push(incomingChar);
		 }
		 
		  
		  
	  }

	private static int getPrecedenceValue(String string) {
		int val= 0;
		  if(string=='+' ||  string=='-') {
			  val = 1;
		  }else if(string=='*' || string=='/') {
			  val = 2;
		  }
		  
		  return val;
	}
	
	private static int calculatePostFixExpression(List<Character> expressionList) {
		
		Stack<Integer> solutionStack = new Stack<>();
		for (Character exp : expressionList) {

			//Character popped = expressionList.pop();
			if(Character.isDigit(exp)) {
				solutionStack.push(Integer.parseInt(Character.toString(exp)));
			}else {
				int answer = evaluate(solutionStack.pop(), solutionStack.pop(), exp);
				solutionStack.push(answer);
			}
			
		
		}
		
		

	      if(solutionStack.size()>1) {
	    	  int number = 0;
	    	  int i = 0 ;
	    	 while(!solutionStack.isEmpty()) {
	    		 int popped = solutionStack.pop();
	    		number += popped * Math.pow(10, i);
	    		i++;
	    	 } 
	    	 return number ;
	      }else {
	    	  return solutionStack.pop();
	      }
	}
	private static void populateExpressionList(Stack<String> expressionStack, List<String> expressionList,
			char incomingExpression) {
		if(!expressionStack.isEmpty() && getPrecedenceValue(incomingExpression+"")<=getPrecedenceValue(expressionStack.peek())) {
			while(!expressionStack.isEmpty()&&getPrecedenceValue(incomingExpression+"")<=getPrecedenceValue(expressionStack.peek())) {
				expressionList.add(expressionStack.pop());
			}
			expressionStack.push(incomingExpression + "");
		}else {
			expressionStack.push(incomingExpression + "");
		}
	}
	*/
}
