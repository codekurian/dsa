package interviewdose.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/
/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = '()'
Output: true
Example 2:

Input: s = '()[]{}'
Output: true
Example 3:

Input: s = '(]'
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 * 
 */
public class ValidParentheses20 {

	public static void main(String[] args) {
		System.out.println(isValid("]"));

	}

	public static boolean isValid(String s) {
		Map<Character,Character> tokenMap  = new HashMap<>();
		//tokenMap.put('(', ')');
		tokenMap.put(')', '(');
		//tokenMap.put('[', ']');
		tokenMap.put(']', '[');
		//tokenMap.put('{', '}');
		tokenMap.put('}', '{');
		char[] tokens = s.toCharArray();
		Stack<Character> tokenStack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			char token = tokens[i];
			
			if(!tokenMap.containsKey(token)|| tokenStack.isEmpty()) {
				//then it is an opening bracket so put in the stack
				tokenStack.add(token);
			}
			else if(tokenMap.get(token)==tokenStack.peek()) {
				tokenStack.pop();
			}else {
				return false;
			}
			
			
			
		}
		if(!tokenStack.isEmpty()) {
			return false;
		}else {
			 List<Integer> returnList  = new ArrayList<Integer>();
			 Integer[] array = returnList.toArray(new Integer[0]);
			 
			return true;
		}
		
	}
}
