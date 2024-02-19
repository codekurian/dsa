package interviewdose.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BasicCalculator224 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String eval = "1-(     -2)";
		System.out.println(calculate(eval));

	}

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

	private static int getPrecedenceValue(String incomingChar) {
		int val = 0;
		if (incomingChar.equals("+") || incomingChar.equals("-")) {
			val = 1;
		}

		return val;
	}

	private static int evaluatePostfix(List<String> postfix) {
		Stack<Integer> stack = new Stack();
		for (String expression : postfix) {
			try {
				int number = Integer.parseInt(expression);
				stack.push(number);
			} catch (NumberFormatException ex) {
				// then it was an operator
				if (expression.equals("-")) {
					int a = -stack.pop();
					stack.push(a);
					
					
				} else {
					if (expression.equals("+")) {
						int a = stack.pop();
						int b = stack.pop();
						stack.push(a + b);
					}
				}

			}

		}
		if(stack.size()>1) {
			stack.push(stack.pop()+stack.pop());
		}

		return stack.pop();
	}

}
