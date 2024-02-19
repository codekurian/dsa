package interviewdose.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeIntervals56 {

	// https://leetcode.com/problems/merge-intervals/description/

	/*
	 * 
	 * Given an array of intervals where intervals[i] = [starti, endi], merge all
	 * overlapping intervals, and return an array of the non-overlapping intervals
	 * that cover all the intervals in the input.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
	 * [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6] overlap,
	 * merge them into [1,6]. Example 2:
	 * 
	 * Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation: Intervals [1,4]
	 * and [4,5] are considered overlapping.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= intervals.length <= 104 intervals[i].length == 2 0 <= starti <= endi <=
	 * 104
	 *
	 * 
	 */
	public static void main(String[] args) {
		int[][] intervals = new int[][] { { 1, 4 }, { 2, 3 } };

		System.out.println(merge(intervals));

	}

	public static int[][] merge(int[][] intervals) {
		int numberOfColumns = intervals.length;
		int numberOfRows = intervals[0].length;
		int[][] mergeArray = new int[numberOfColumns][numberOfRows];
		
		//sort by left index
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		int intervalsIndex = 1 ;
		int mergeArrayIndx= 0;
		mergeArray[mergeArrayIndx]= intervals[mergeArrayIndx];
		while(intervalsIndex<=intervals.length-1) {
			int[] left = mergeArray[mergeArrayIndx];
			int[] right = intervals[intervalsIndex];
			//{ 1, 3 }, { 2, 6 }
			if(right[0]<=left[1]) {
				int [] merge = new int [2];
				
				if(left[1]<=right[1]) {
					merge[1]=right[1];
				}else {
					merge[1]=left[1];
				}
				merge[0]=left[0];
				
				mergeArray[mergeArrayIndx]=merge;
				intervalsIndex++;
				
				//[[1,4],[2,3]]
			}else {
				//mergeArray[mergeArrayIndx++]=left;
				mergeArray[++mergeArrayIndx]=right;
				intervalsIndex++;
			}
			
		}

		return Arrays.copyOfRange(mergeArray, 0, mergeArrayIndx+1);
	}
}
