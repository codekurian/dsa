package interviewdose.bitwise;

import java.util.HashMap;
import java.util.Map;

public class Majorityelement138 {

	//https://leetcode.com/problems/majority-element/
	/*
	 * Given an array nums of size n, return the majority element.

		The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
		
		 
		
		Example 1:
		
		Input: nums = [3,2,3]
		Output: 3
		Example 2:
		
		Input: nums = [2,2,1,1,1,2,2]
		Output: 2
		 
		
		Constraints:
		
		n == nums.length
		1 <= n <= 5 * 104
		-109 <= nums[i] <= 109
		 	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] quesArray = {3,2,3};
		System.out.println(findMajorityNumberUsingBitwise(quesArray));
	}
	

 
	  


static int findMajorityNumberUsingBitwise(int[] nums) {
	
	int[] indexSumArray = new int [32] ;
	int signCount = 0 ;
	int timesMajorityExists = nums.length/2+1;
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
			
			// set bit if greater than arraysize/2 + 1 then the bit has to be considered for calculation
			if(indexSumArray[k] > timesMajorityExists || (indexSumArray[k] > 0 && indexSumArray[k]%timesMajorityExists==0) ) {
				//System.out.println("index "+k+"the sum is "+indexSumArray[k]);
				number+=Math.pow(2, k);
			}
			
		}
		if(signCount != 0 && signCount%timesMajorityExists==0) {
			//negative number exists less than 3 times
			number=number*-1;
		}
	
	
	
	return (int) number;
	 
    
 }
     

}
