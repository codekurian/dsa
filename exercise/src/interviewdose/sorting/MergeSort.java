package interviewdose.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] arrayToBeSorted =  new  int[]{5,2,3,1};
		mergeSort(arrayToBeSorted, 0, arrayToBeSorted.length-1);
		for (int i = 0; i < arrayToBeSorted.length; i++) {
			System.out.println(arrayToBeSorted[i]+",");
		}
		
		

	}
	public int[] sortArray(int[] nums) {
		mergeSort(nums, 0, nums.length-1);
        return nums ;
    }

	/**
	 * @param nums
	 * @return
	 * Iterate through the complete array find the minimum and swap 
	 * After each pass the minuimum will come to the left and that will be considered partitioned and we will not touch it again 
	 */
	
	
	public static void mergeSort(int [] nums,int lowIndex,int highIndex) {
		//nums =[2,0,2,1,1,0]
		if(lowIndex>=highIndex) {
			return ;
		}else {
			int mid = findMid(lowIndex, highIndex);
			mergeSort(nums, lowIndex, mid);
			mergeSort(nums, mid+1, highIndex);
           
			merge(nums,mid,lowIndex,highIndex);
		}
			
		
	}

	private static void merge(int[] array, int mid,int lowIndex,int highIndex) {
		int [] sortedMergedArray = new int[highIndex-lowIndex+1];
		int leftPartitionIndex = lowIndex;
		int rightPartitionIndex = mid+1 ;
		int j = 0 ;
		while(leftPartitionIndex<=mid&&rightPartitionIndex<=highIndex) {
			
			if(array[leftPartitionIndex]<=array[rightPartitionIndex]) {
				sortedMergedArray[j++]=array[leftPartitionIndex++];
				
			}else {
				sortedMergedArray[j++]=array[rightPartitionIndex++];
							}
			
		}
		while(leftPartitionIndex<=mid) {
			
			sortedMergedArray[j++]=array[leftPartitionIndex++];

		}
		
		while(rightPartitionIndex<=highIndex) {
			sortedMergedArray[j++]=array[rightPartitionIndex++];
				}
		
		for (int i = 0,k=lowIndex; i < sortedMergedArray.length; i++,k++) {
			array[k] = sortedMergedArray[i];
			
		}
	}
		
	

	
	
	private static int  findMid(int lowIndex, int highIndex) {
		 return lowIndex+((highIndex-lowIndex)/2);
	}
	
	
}