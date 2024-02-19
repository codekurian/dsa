package interviewdose.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//https://leetcode.com/problems/majority-element-ii/description/

//NOT SOLVED FOR 1.2
public class MajorityElementII229 {

	/*
	 * 229. Majority Element II Medium Topics Companies Hint Given an integer array
	 * of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [3,2,3] Output: [3] Example 2:
	 * 
	 * Input: nums = [1] Output: [1] Example 3:
	 * 
	 * Input: nums = [1,2] Output: [1,2]
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= nums.length <= 5 * 104 -109 <= nums[i] <= 109
	 * 
	 * 
	 * Follow up: Could you solve the problem in linear time and in O(1) space?
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { 1,2 };

		System.out.println(majorityElement(nums));

	}

	public static List<Integer> majorityElement(int[] nums) {
	
		return findMajorityElement(nums, (nums.length / 3) + 1);
		
	}

	public static List<Integer> findMajorityElement(int[] nums,  int occuranceCount) {
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				int count = map.get(nums[i])+1;
				map.put(nums[i],count );
			}else {
				map.put(nums[i],1 );
			}
			
			
		}
		
		return map.entrySet().stream().filter(e->e.getValue()>=occuranceCount).map(Map.Entry::getKey).collect(Collectors.toList());
		
	}

	
}
