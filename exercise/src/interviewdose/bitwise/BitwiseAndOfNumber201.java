package interviewdose.bitwise;

import java.util.HashMap;
import java.util.Map;

public class BitwiseAndOfNumber201 {

	//https://leetcode.com/problems/bitwise-and-of-numbers-range/
	/*
	 * 
	 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

		 
		
		Example 1:
		
		Input: left = 5, right = 7
		Output: 4
		Example 2:
		
		Input: left = 0, right = 0
		Output: 0
		Example 3:
		
		Input: left = 1, right = 2147483647
		Output: 0
		 
		
		Constraints:
		
		0 <= left <= right <= 231 - 1
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(rangeBitwiseAnd(5,7));
	}
	

 
	  

		public static int rangeBitwiseAnd(int left, int right) {
			

			
			int[] indexSumArray = new int [32] ;
					for (int i = 0; i < indexSumArray.length; i++) {
					indexSumArray[i]=Integer.MIN_VALUE;
					
				}
				
				for (int i = left; i <=right; i++) {
					int bitmovement = 0;
					
					while(bitmovement<32) {
						int binaryValueAtIndex = Integer.MIN_VALUE;
						if(indexSumArray[bitmovement]!=0) {
							binaryValueAtIndex = i>>bitmovement&1;
							
							if(binaryValueAtIndex == 0 ) {
								indexSumArray[bitmovement]=0;
							}else {
								if(indexSumArray[bitmovement]==Integer.MIN_VALUE) {
									indexSumArray[bitmovement]=1;
								}else {
									indexSumArray[bitmovement]+=binaryValueAtIndex;
								}
								
								
							}
						}
						
						//System.out.println("binaryValueAtIndex arrayindex :"+i +" bit : "+" "+bitmovement + " Value :: "+binaryValueAtIndex);
						
						//left shift 32 times since it is an integer and get the bits
						
						bitmovement++;
						
						
					}
					
					
				}
				long number = 0 ;
				//System.out.println(indexSumArray.length);
				for (int k = 0; k < indexSumArray.length; k++) {
					//System.out.println("indexSumArray[k] "+k+" "+indexSumArray[k]);
					
					// set bit if greater than arraysize/2 + 1 then the bit has to be considered for calculation
					if(indexSumArray[k] > 0) {
						System.out.println("index "+k+"the sum is "+indexSumArray[k]);
						number+=Math.pow(2, k);
					}
					
				}
				
				
			
			
			
			return (int) number;
			 
		    
		 
		}
     

}
