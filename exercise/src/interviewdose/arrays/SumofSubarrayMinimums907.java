package interviewdose.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

	 
	
	Example 1:
	
	Input: arr = [3,1,2,4]
	Output: 17
	Explanation: 
	Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
	Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
	Sum is 17.
	Example 2:
	
	Input: arr = [11,81,94,43,3]
	Output: 444
	 
	
	Constraints:
	
	1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
 */
//https://leetcode.com/problems/sum-of-subarray-minimums/description/
public class SumofSubarrayMinimums907 {

	public static void main(String[] args) {
		int[] arr = new int [] {11,81,94,43,3};
		System.out.println(sumSubarrayMins(arr));

	}
	
	
public static int sumSubarrayMins(int[] arr) {
    int maxSum = Integer.MAX_VALUE;
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
    	
    	sum +=arr[i];
    	//Greedy if you get a chance to clear the Debt clear it by setting it with the current value 
    	if(sum>arr[i]) {
    		sum=arr[i];
    	}
    	//if the max sum is greater than previous max then that is the max sum 
    	if(maxSum>sum) {
    		maxSum = sum;
    	}
	}
    return maxSum;
}

}
