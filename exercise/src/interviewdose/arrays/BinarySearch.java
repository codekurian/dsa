package interviewdose.arrays;

public class BinarySearch {

	public static void main(String[] args) {
		//Binary Search
		int[] arrayToBeSearched = new int [] {1,2,3,4,5,6};
		int numberToBeSearched = 4;
		int idx = binarySearch(arrayToBeSearched,numberToBeSearched,0,arrayToBeSearched.length-1);
		System.out.println("number is at "+idx);

	}

	private static int binarySearch(int[] arrayToBeSearched,int numberToBeSearched, int low, int high) {
		// TODO Auto-generated method stub
		//find mid
		int midIdx  = partition(arrayToBeSearched,low,high);
		if(arrayToBeSearched[midIdx]==numberToBeSearched) {
			return midIdx;
		}
		if(low>high) {
			return -1;
		}
		if(low<high) {
			if(numberToBeSearched<arrayToBeSearched[midIdx]) {
				//search on the left of mid
				return binarySearch(arrayToBeSearched, numberToBeSearched, low, midIdx-1);
			}else {
				//search on the right of mid
				return binarySearch(arrayToBeSearched, numberToBeSearched, midIdx+1, high);
			}
		}
		
		return midIdx;
	}

	private static int partition(int[] arrayToBeSearched, int low, int high) {
		int mid = low+(high-low)/2;
		
		return mid;
	}

}
