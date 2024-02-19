package interviewdose.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum15 {

	// https://leetcode.com/problems/3sum/description/

	/*
	 * 
	 * Given an integer array nums, return all the triplets [nums[i], nums[j],
	 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
	 * nums[k] == 0.
	 * 
	 * Notice that the solution set must not contain duplicate triplets.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Explanation:
	 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] =
	 * 0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0. The
	 * distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the order of the
	 * output and the order of the triplets does not matter. Example 2:
	 * 
	 * Input: nums = [0,1,1] Output: [] Explanation: The only possible triplet does
	 * not sum up to 0. Example 3:
	 * 
	 * Input: nums = [0,0,0] Output: [[0,0,0]] Explanation: The only possible
	 * triplet sums up to 0.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 3 <= nums.length <= 3000 -105 <= nums[i] <= 105
	 *
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };

		System.out.println(threeSum(nums));

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<Set<Integer>> threeSum = new ArrayList<Set<Integer>>();
		List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			
			int leftindx = i+1 ;
			int rightIndx = nums.length-1 ;
			
			
			
			
			while(leftindx<rightIndx) {
				int sum = nums[i]+nums[leftindx]+nums[rightIndx];
				List<Integer> targetPair = new ArrayList<>();
				if(sum==0) {
					targetPair.add(nums[i]);
					targetPair.add(nums[leftindx]);
					targetPair.add(nums[rightIndx]);
					returnList.add(targetPair);
					leftindx++;
				}
				else if(sum>0) {
					rightIndx--;
				}else if(sum<0){
					leftindx++;
				}else {
					

				}
			}
			
						
		}
		
		return returnList;
	}

	
}
