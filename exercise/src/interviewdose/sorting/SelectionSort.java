package interviewdose.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		System.out.println(selectonSort(new int[]{2,0,2,1,1,0}));
		
		
		

	}

	/**
	 * @param nums
	 * @return
	 * Iterate through the complete array find the minimum and swap 
	 * After each pass the minuimum will come to the left and that will be considered partitioned and we will not touch it again 
	 */
	public static int[] selectonSort(int [] nums) {
		//nums =[2,0,2,1,1,0]
		for(int i = 0 ; i < nums.length ;i++) {
			int indexOfMinimumNumber = i ;
			for (int j = i+1; j < nums.length; j++) {
				if(nums[j]<nums[indexOfMinimumNumber]) {
					indexOfMinimumNumber = j;
				}
				 //swap
				 
			}
			if(nums[i]>nums[indexOfMinimumNumber]) {
				swapNumbersinArray(nums, i, indexOfMinimumNumber);

			}
						
					}
		return nums;
	}

	private static int[]  swapNumbersinArray(int[] numbers, int indexOfA, int indexOfB) {
		 int a = numbers[indexOfA];
		 numbers[indexOfA] = numbers[indexOfB] ;
		 numbers[indexOfB]=a;
		 return numbers;
	}
	
	
}
