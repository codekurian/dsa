package interviewdose.arrays;

public class MaximumSubarray53 {

	//https://leetcode.com/problems/maximum-subarray/description/
	/*
	 * Given an integer array nums, find the 
		subarray
		 with the largest sum, and return its sum.
		
		 
		
		Example 1:
		
		Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
		Output: 6
		Explanation: The subarray [4,-1,2,1] has the largest sum 6.
		Example 2:
		
		Input: nums = [1]
		Output: 1
		Explanation: The subarray [1] has the largest sum 1.
		Example 3:
		
		Input: nums = [5,4,-1,7,8]
		Output: 23
		Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
		 
		
		Constraints:
		
		1 <= nums.length <= 105
		-104 <= nums[i] <= 104
			 */
	public static void main(String[] args) {
		int [] nums = new int [] {-1};
		System.out.println(maxSubArray(nums));

	}
//Kadance Algorithm
public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
        	
        	sum +=nums[i];
        	//Greedy if you get a chance to clear the Debt clear it by setting it with the current value 
        	if(sum<nums[i]) {
        		sum=nums[i];
        	}
        	//if the max sum is greater than previous max then that is the max sum 
        	if(maxSum<sum) {
        		maxSum = sum;
        	}
		}
        return maxSum;
    }
}
