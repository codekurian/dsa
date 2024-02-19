package interviewdose.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int[] sorted = bubbleSort(new int[]{1,1,1,1,1,1});
		for (int i = 0; i < sorted.length; i++) {
			int j = sorted[i];
			System.out.println(j+"->");
			
		}

		
		
		

	}

	/**
	 * @param nums
	 * @return
	 * Compare adjacent elements in the array . The largest element will bubble to the end of the array
	 * After each pass the since the max will bubble at the end we need not 
	 * Optimize it if the array is already sorted we just break the loop
	 */
	public static int[] bubbleSort(int [] nums) {
		//nums =[2,1]
		
		for(int i = 0 ; i < nums.length-1 ;i++) {
			boolean isSwapped = false;
			for (int j = 0 ; j < nums.length-i-1; j++) {
				if(nums[j]>nums[j+1]) {
					isSwapped = true;
					swapNumbersinArray(nums, j, j+1);
				}
			}
			if(!isSwapped) {
				System.out.println("break for i  " +i );
				break;
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
