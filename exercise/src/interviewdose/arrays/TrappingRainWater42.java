package interviewdose.arrays;
/*
 *Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 * 
 * 
 * 
 */
//https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater42 {

	public static void main(String[] args) {
		int[] arr = new int [] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(arr));

	}
	
	
public static int trap(int[] height) {
        
        int maxVolume = 0;
        
        
        //water that can be stored is equal to minimum of left and right heights - height at the index
        //loop through and find the highest from left 
        int [] highestFromLeft = new int [height.length];
        int highestHeight = 0;
        for (int i = 0; i < height.length; i++) {
        	
        	highestFromLeft[i]=highestHeight;
			if(height[i]>highestHeight) {
				highestHeight = height[i];
			}
			
			
		}
        int [] highestFromRight = new int [height.length];
        //loop through and find the max array
        highestHeight = 0;
        for (int i = height.length-1; i >= 0; i--) {
        	
        	highestFromRight[i]=highestHeight;
			if(height[i]>highestHeight) {
				highestHeight = height[i];
			}
			
			
		}
        
        for (int i = 0; i < height.length; i++) {
			int j = height[i];
			int heightDueToLeftAndRightStructures = Math.min(highestFromLeft[i], highestFromRight[i]);
			if(heightDueToLeftAndRightStructures>height[i]) {
				maxVolume+=heightDueToLeftAndRightStructures-height[i];
			}
			
		}
        
        return maxVolume;
        
    }

}
