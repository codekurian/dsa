package interviewdose.bitwise;

import java.util.HashMap;
import java.util.Map;

public class HammingDistance461 {

	//https://leetcode.com/problems/hamming-distance/
	/*
	 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

				Given two integers x and y, return the Hamming distance between them.
				
				 
				
				Example 1:
				
				Input: x = 1, y = 4
				Output: 2
				Explanation:
				1   (0 0 0 1)
				4   (0 1 0 0)
				       ↑   ↑
				The above arrows point to positions where the corresponding bits are different.
				Example 2:
				
				Input: x = 3, y = 1
				Output: 1
				 
				
				Constraints:
				
				0 <= x, y <= 231 - 1
	 *	 */
	public static void main(String[] args) {
		
		System.out.println(hammingDistance(3, 1));
	}
	

 
	public static int hammingDistance(int x, int y) {
	 //xor both numbers and add them
		int num = x^y;
		int numberOfBits = (int)(Math.log(num) /  Math.log(2) + 1);
		//leftshift
		int hammingDistance=0;
		for(int i = 0 ;i<=numberOfBits;i++) {
			int trueBit = num >> i &1;
		if(trueBit!=0) {
			hammingDistance+=1;
		}
		    
		}
		
		return hammingDistance;
	 }
}
