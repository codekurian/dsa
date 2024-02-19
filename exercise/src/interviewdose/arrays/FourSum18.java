package interviewdose.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FourSum18 {

	//
	/*
	 * Given an array nums of n integers, return an array of all the unique
	 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
	 * 
	 * 0 <= a, b, c, d < n a, b, c, and d are distinct. nums[a] + nums[b] + nums[c]
	 * + nums[d] == target You may return the answer in any order.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [1,0,-1,0,-2,2], target = 0 Output:
	 * [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]] Example 2:
	 * 
	 * Input: nums = [2,2,2,2,2], target = 8 Output: [[2,2,2,2]]
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= nums.length <= 200 -109 <= nums[i] <= 109 -109 <= target <= 109
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { 1,0,-1,0,-2,2 };
		System.out.println(fourSum(nums, 0));
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> fourSum = new HashSet<List<Integer>>();
		Arrays.sort(nums);

		

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					long sum = nums[i] + nums[j] ;
					long searchTarget = target -sum;
					if (nums[left] + nums[right] > searchTarget) {
						right--;
					} else if (nums[left] + nums[right] < searchTarget) {
						left++;
					} else {
						// sum==target;
						List<Integer> tuples = new ArrayList<>();
						tuples.add(nums[i]);
						tuples.add(nums[j]);
						tuples.add(nums[left]);
						tuples.add(nums[right]);
						fourSum.add(tuples);
						right--;
					}

				}
			}

		}
		return fourSum.stream().collect(Collectors.toList());
	}
}
