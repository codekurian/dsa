package interviewdose.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElementI496 {

	public static void main(String[] args) {
		int nums1[] = new int [] {4,1,2};
		int nums2[] = new int [] {1,3,4,2};
		int[] ans = nextGreaterElementOptimized(nums1,nums2);
		for (int i = 0; i < ans.length; i++) {
			int j = ans[i];
			System.out.println(j+" ");
		}
		

	}
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
	    List<Integer> returnList  = new ArrayList<Integer>();
	    
	    for(int i = 0 ;i<nums1.length ;i++){
	        int foundIndex = -1 ;
	    Stack<Integer> nums2Stack = new Stack<Integer>();

	        int number = nums1[i];
	       
	        boolean foundTheSameNumber = false;
	        for(int j=0;j<nums2.length;j++){
	           if(foundTheSameNumber && nums2[j] > number){
	             foundIndex = j ;
	             returnList.add( nums2[j]);
	             break;
	              
	            }
	            if(nums2[j]==number){
	                foundTheSameNumber = true;
	            }
	            
	        }
	        if(foundIndex==-1){
	             returnList.add(foundIndex);
	        }
	       
	        
	    }
	    
	     int[] array = returnList.stream().mapToInt(i -> i).toArray();

	    return array ; 
	}
	
	public static int[] nextGreaterElementOptimized(int[] nums1, int[] nums2) {
		//prerpocess nums2 array to get the hashmap with next greater element for each element by using a stack
		//we have to follow strictly decreasing curve
		//we can add on stack only those elements which are smaller than what is already on the top of stack .
		//alse please note we are iterating array left to right
		
		Stack<Integer> preprocessStack = new Stack<>();
		HashMap<Integer, Integer> greaterMap = new HashMap<>();
		for (int i =0; i <= nums2.length-1; i++) {
			int number = nums2[i];
			if(preprocessStack.isEmpty()) {
				preprocessStack.push(number);
			}else if(number<=preprocessStack.peek()) {
				preprocessStack.push(number);
			}else {
				while(!preprocessStack.isEmpty() && number>preprocessStack.peek()) {
					int numberFromStack = preprocessStack.pop();
					greaterMap.put(numberFromStack,number);
				}
				preprocessStack.push(number);
				
			}
			
		}
		while(!preprocessStack.isEmpty()) {
			int numberFromStack = preprocessStack.pop();
			greaterMap.put(numberFromStack, -1);
		}
		
		int[] returnArray = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			returnArray[i]=greaterMap.get(nums1[i]) ;
			
		}
		return returnArray ; 
	}
}


