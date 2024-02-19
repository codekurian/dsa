package interviewdose.arrays;

//https://leetcode.com/problems/majority-element/description/


//Moore's Voting Algorithm
public class MajorityElement169 {
	/*
	 * Given an array nums of size n, return the majority element.
	 * 
	 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
	 * may assume that the majority element always exists in the array.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [3,2,3] Output: 3 Example 2:
	 * 
	 * Input: nums = [2,2,1,1,1,2,2] Output: 2
	 * 
	 * 
	 * Constraints:
	 * 
	 * n == nums.length 1 <= n <= 5 * 104 -109 <= nums[i] <= 109
	 * 
	 * 
	 * Follow-up: Could you solve the problem in linear time and in O(1) space?
	 */
	public static void main(String[] args) {
		int[] nums = new int[] {6,5,5};
		System.out.println(majorityElement(nums));
	}
	public static int majorityElement(int[] nums) {
		return findMajorityElement(nums,nums[0]);
	}
	
	public static  int findMajorityElement(int[] nums,int probableMajorityElement) {
	        int majorityElement = probableMajorityElement;
	        int majorityCount = 0;
	        for (int i = 0; i < nums.length; i++) {
	        	if(nums[i]==majorityElement) {
	        		
	        		majorityCount++;
	        	}else if(majorityCount!=0 && nums[i]!=majorityElement){
	        		majorityCount--;
	        	}else if(majorityCount==0 && nums[i]!=majorityElement) {
	        		majorityElement = nums[i];
	        		majorityCount++;
	        	}
	        	
				
			}
	        if(isMajorityOcuringMaxOccurence(nums, majorityElement, (nums.length/2)+1)) {
	        	return majorityElement;
	        }else {
	        	return findMajorityElement(nums,majorityElement);
	        }
	     
	    }
public static boolean isMajorityOcuringMaxOccurence(int[] nums,int majorityElement,int maxOccurance) {
	int occurance = 0;
	for (int i = 0; i < nums.length; i++) {
		if(nums[i]==majorityElement) {
			occurance++;
		}
		
	}
	if(occurance>=maxOccurance) {
		return true;
	}else {
		return false;
	}
}
}
