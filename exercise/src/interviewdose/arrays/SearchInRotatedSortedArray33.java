package interviewdose.arrays;

//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
//https://www.youtube.com/watch?v=k9pbGyY3L5E
public class SearchInRotatedSortedArray33 {

	public static void main(String[] args) {
		int[] arrayToBeSearched = new int [] {4,5,6,7,0,1,2};
		
		int numberToBeSearched = 0;
		int idx = search(arrayToBeSearched, numberToBeSearched);
		binarySearch(arrayToBeSearched,numberToBeSearched,0,arrayToBeSearched.length-1);
		System.out.println("number is at "+idx);

	}

	private static int binarySearch(int[] arrayToBeSearched, int numberToBeSearched, int si, int ei) {
		
		if(si>ei) {
			return -1;
		}else {
			int midIndx = partition(arrayToBeSearched,numberToBeSearched,si,ei);
			if(numberToBeSearched==arrayToBeSearched[midIndx]) {
				return midIndx;
			}
			//1 : line 1
			if(arrayToBeSearched[si]<=arrayToBeSearched[midIndx]) {
				
			//CASE 1: Left of L1
				if(arrayToBeSearched[si]<=numberToBeSearched && numberToBeSearched <= arrayToBeSearched[midIndx]) {
					return binarySearch(arrayToBeSearched,numberToBeSearched,si,midIndx-1);
				}else {
					//CASE 2 : Right of L1
					return binarySearch(arrayToBeSearched,numberToBeSearched,midIndx+1,ei);
				}
				
			
			}else {
				// CASE 1: More than mid of line 2
				if(numberToBeSearched>=arrayToBeSearched[midIndx]&&numberToBeSearched<=arrayToBeSearched[ei]) {
					return binarySearch(arrayToBeSearched,numberToBeSearched,midIndx+1,ei);
				}else {
					return binarySearch(arrayToBeSearched,numberToBeSearched,si,midIndx-1);
				}
			}
			
		
			
		}
		
	}

	private static int partition(int[] arrayToBeSearched, int numberToBeSearched, int low, int high) {
		return low+((high-low)/2);
		
	}

	public static int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

}
