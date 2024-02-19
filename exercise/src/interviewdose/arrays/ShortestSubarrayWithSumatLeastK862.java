package interviewdose.arrays;

import java.util.Arrays;

public class ShortestSubarrayWithSumatLeastK862 {

	// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
	//explanation
	/*
	 * Given an integer array nums and an integer k, return the length of the
	 * shortest non-empty subarray of nums with a sum of at least k. If there is no
	 * such subarray, return -1.
	 * 
	 * A subarray is a contiguous part of an array.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1], k = 1 Output: 1 
	 * 
	 * Example 2:
	 * 
	 * Input: nums = [1,2], k = 4 Output: -1 
	 * 
	 * 
	 * Example 3:
	 * 
	 * Input: nums = [2,-1,2], k = 3 Output: 3
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= nums.length <= 105 -105 <= nums[i] <= 105 1 <= k <= 109
	 */
	public static void main(String[] args) {
		int[] nums = new int[] {1,2 };
		System.out.println(shortestSubarray(nums, 4));

	}
	
	public static int shortestSubarray(int[] nums, int k) {
	        int subArrayLenth = Integer.MAX_VALUE;
	        
	        
	        int maxSum = 0;
	        
	        int left = 0 ;
	        int right = 1 ;
	        for (int i = 0; i < nums.length; i++) {
	        	maxSum=nums[left]+nums[right];
	        	while(left<right){
	        		
	        		if(k>=maxSum) {
	        			subArrayLenth=right-left+2;
	        			maxSum=maxSum-nums[left];
	                	left++;
	                	
	                }else if(k<maxSum) {
	                	maxSum=maxSum+nums[right];
	                	right++;
	                	
	                }
	        	}
	        	
	        	
				
			}
	        
	        
	        return subArrayLenth;
	    }

}
