package interviewdose.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/description/
public class CombinationSum39 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<>();
		for (int i = 0; i < candidates.length - 1; i++) {
			List<Integer> combinations = new ArrayList<>();
			int sum = 0;
			bfsTargetSum(candidates, i, target, sum, combinations);

			if (sum==target) {
				result.add(combinations);
			}

		}

		return result;

	}
	
	public void bfsTargetSum(int[] candidates, int currentIndex,int target, int sum,
			List<Integer> combinations) {

		// base condition
		if (sum == target) {
			// this is the found one
			
			return;
		}
     if(currentIndex == candidates.length-1 || sum> target) {
    	 return;
     }
     sum += candidates[currentIndex];
     combinations.add(candidates[currentIndex]);
     if(sum>target) {
    	sum -= candidates[currentIndex];
    	combinations.remove(combinations.size()-1);
     }
     bfsTargetSum(candidates, currentIndex++, target, sum, combinations);

	}


	public void bfs(int[] candidates, int currentIndex, int selectedElementIndex, int target, int sum,
			List<Integer> combinations) {

		// base condition
		if (sum == target || selectedElementIndex == candidates.length) {
			// this is the found one
			return;
		}

		if (canBeAdded(sum, target, candidates[currentIndex])) {
			sum += candidates[currentIndex];
			combinations.add(candidates[currentIndex]);

		} else {
			return;
		}
		for (int i = selectedElementIndex; i < candidates.length; i++) {

			if (sum < target) {

				sum += candidates[selectedElementIndex];
				combinations.add(candidates[selectedElementIndex]);
				System.out.println("combinations Added ::" + combinations);
			}
			// if the sum is greater than the target sum we need to clean the result
			if (sum > target) {
				sum -= candidates[selectedElementIndex];
				combinations.remove(combinations.size() - 1);
				System.out.println("combinations Removed ::" + combinations);

				return;
			}
			bfs(candidates, currentIndex, selectedElementIndex++, target, sum, combinations);
		}

		// try to add it in the sum if the sum is less

		// if we have reached the end of the array

	}
	
	
	boolean canBeAdded(int currentSum, int targetSum, int valueToBeAdded) {
		if (valueToBeAdded + currentSum <= targetSum) {
			return true;
		} else {
			return false;
		}
	}
}
