package interviewdose.greedy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/jump-game-ii/description/
public class JumpGameII45 {

	
	public int jump(int[] nums) {
		int selectedIndex = nums.length - 1;
		Stack<Integer> indexes = new Stack<>();
		int hops = 0;
		for (int i = nums.length; i > 0; i--) {
			selectedIndex = selectIndexToMaxPath(nums, selectedIndex);
			indexes.push(selectedIndex);

		}
		while(!indexes.isEmpty()) {
			int index = indexes.pop();
			if(index+nums[index]<=nums.length) {
				hops++;
				if(index+nums[index]==nums.length) {
					break;
				}
			}
		}

		return hops;
	}

	public int selectIndexToMaxPath(int[] nums, int selectedIndex) {
		int nextSelectedIndex=selectedIndex ;
		for (int i = selectedIndex - 1; i > 0; i--) {
           
			int jump = nums[i];
			if ((i + jump) >= selectedIndex) {
                
				nextSelectedIndex = i;
                System.out.println("returned nextSelectedIndex " + nextSelectedIndex);
                 return nextSelectedIndex;
				

			}

		}
		System.out.println("returned nextSelectedIndex " + nextSelectedIndex);
		return nextSelectedIndex;
	}
}
