package interviewdose.bitwise;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber137 {

	//https://leetcode.com/problems/single-number-ii/
	/*
	 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
	 * Example 1:

		Input: nums = [2,2,3,2]
		Output: 3
		Example 2:
		
		Input: nums = [0,1,0,1,0,1,99]
		Output: 99
		 
		
		Constraints:
		
		1 <= nums.length <= 3 * 104
		-231 <= nums[i] <= 231 - 1
		
		Adding set bit on the number and doing a mod operator by the number of times it is repeating should result in 0 if it is non zero that means that the bit is set by some number which has not repeated same number of times
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] quesArray = {-2147483648,2,2,2};
		System.out.println(findSingleNumberUsingBitwise(quesArray));
	}
	

 
	static int findSingleNumberUsingBitwise(int[] nums) {
		
		int[] indexSumArray = new int [32] ;
		int signCount = 0 ;
			for (int i = 0; i < indexSumArray.length; i++) {
				indexSumArray[i]=0;
				
			}
			
			for (int i = 0; i < nums.length; i++) {
				int bitmovement = 0;
				
				while(bitmovement<32) {
					int binaryValueAtIndex = 0;
					
					if(nums[i]<0) {
						//its a negetive number and stored as 2s complement in java that means inverting all the bits to 1 
						/*
						 * Two’s complement = one’s complement + one.

							Where one’s complement is the value obtained by inverting all the bits of the binary representation of the number.
							
							example:
							
							8 bits binary representation of number 9 (it’s absolute value): 0000 1001
							
							getting it’s one’s complement by swapping zeros and ones: 1111 0110
							
							getting two’s complement by adding one to one’s complement to get negative 9: 1111 0110 + 0000 0001 = 1111 0111
						 */
						//
						binaryValueAtIndex = (-1*nums[i])>>bitmovement&1;
					    
					}else {
						 binaryValueAtIndex = nums[i]>>bitmovement&1;
					}
					   
					//System.out.println("binaryValueAtIndex arrayindex :"+i +" bit : "+" "+bitmovement + " Value :: "+binaryValueAtIndex);
					
					//left shift 32 times since it is an integer and get the bits
					indexSumArray[bitmovement]+=binaryValueAtIndex;
					bitmovement++;
					
				}
				if(nums[i]<0) {
					signCount++;
				}
				
				
			}
			long number = 0 ;
			//System.out.println(indexSumArray.length);
			for (int k = 0; k < indexSumArray.length; k++) {
				//System.out.println("indexSumArray[k] "+k+" "+indexSumArray[k]);
				if(indexSumArray[k]%3!=0) {
					//System.out.println("index "+k+"the sum is "+indexSumArray[k]);
					number+=Math.pow(2, k);
				}
				
			}
			if(signCount%3!=0) {
				//negative number exists less than 3 times
				number=number*-1;
			}
		
		
		
		return (int) number;
		 
        
     }
     

}
