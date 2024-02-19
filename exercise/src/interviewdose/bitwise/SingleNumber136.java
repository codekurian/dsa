package interviewdose.bitwise;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber136 {

	//https://leetcode.com/problems/single-number/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int findSingleNumberUsingHashMap(int[] nums) {
		Map<Integer,Integer> numberMap = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(numberMap.get(nums[i]) != null){
	            //we already have a number and we need to add 1
	            numberMap.put(nums[i],nums[i]+1);  
	        }else{
	            numberMap.put(nums[i],1);  
	        }
	       
		}
		return numberMap.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().get();
		 
        
     }
 
	static int findSingleNumberUsingBitwise(int[] nums) {
		int number = 0;
		for (int i = 0; i < nums.length; i++) {
			number ^= nums[i]   ;
		}
		return number;
		 
        
     }
     

}
