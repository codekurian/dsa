package interviewdose.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/4sum-ii/description/
public class FourSumII454 {

	//
	/*
	 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
	 * return the number of tuples (i, j, k, l) such that:
	 * 
	 * 0 <= i, j, k, l < n nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2] Output:
	 * 2 Explanation: The two tuples are: 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] +
	 * nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0 2. (1, 1, 0, 0) -> nums1[1] +
	 * nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0 Example 2:
	 * 
	 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0] Output: 1
	 * 
	 * 
	 * Constraints:
	 * 
	 * n == nums1.length n == nums2.length n == nums3.length n == nums4.length 1 <=
	 * n <= 200 -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
	 */
	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2 };
		int[] nums2 = new int[] { -2, -1 };
		int[] nums3 = new int[] { -1, 2 };
		int[] nums4 = new int[] { 0, 2 };
		System.out.println(fourSumCount(nums1, nums2, nums3, nums4));

	}

	public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int tuplecount = 0;
		Map<Integer, Integer> nums3Andnums4Sum = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums3.length; i++) {
			for (int j = 0; j < nums4.length; j++) {

				int key = nums3[i] + nums4[j];
				if (nums3Andnums4Sum.containsKey(key)) {

					nums3Andnums4Sum.put(key, nums3Andnums4Sum.get(key) + 1);
				} else {

					nums3Andnums4Sum.put(key, 1);
				}
			}
		}

		for (int k = 0; k < nums1.length; k++) {
			for (int l = 0; l < nums2.length; l++) {
				int sum = nums1[k] + nums2[l];
				int target = 0 - sum;
				if (nums3Andnums4Sum.containsKey(target)) {
					tuplecount = tuplecount + nums3Andnums4Sum.get(target);
				}
			}

		}

		return tuplecount;

	}
}
