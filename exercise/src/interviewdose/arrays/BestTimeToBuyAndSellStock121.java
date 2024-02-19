package interviewdose.arrays;

public class BestTimeToBuyAndSellStock121 {

	//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
	/*
	 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

		You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
		
		Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
		
		 
		
		Example 1:
		
		Input: prices = [7,1,5,3,6,4]
		Output: 5
		Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
		Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
		Example 2:
		
		Input: prices = [7,6,4,3,1]
		Output: 0
		Explanation: In this case, no transactions are done and the max profit = 0.
		 
		
		Constraints:
		
		1 <= prices.length <= 105
		0 <= prices[i] <= 104
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {7,1,5,3,6,4};
		//slide window from k = 2 to 6 ()
	
		System.out.println(maxProfit(nums));

	}
	
	
	/*public static int maxProfit(int[] prices) {
		int boughtIndx = 0;
		
		int maxSum = 0;
		int k = 1;
		int soldIndx = boughtIndx+k ;
		while (k<=prices.length-1) {
			
			 for (int i = 0; i <= prices.length-k-1; i++) {
				 soldIndx=i+k;
				 boughtIndx=i;
				  if(prices[soldIndx]>prices[boughtIndx]) {
					  //we are making profit
					  if(prices[soldIndx]-prices[boughtIndx]>maxSum) {
						  maxSum = prices[soldIndx]-prices[boughtIndx];
						 // soldIndx=i;
						  
					  }
					  
				  }
				 
		}
	 
		  k++;
		  
		 
	}
		
		return maxSum;      
	  }*/
	
	public static int maxProfit(int[] prices) {
		int minimumIdx = 0;
		
		int maxSum = 0;
		for (int i = 0; i < prices.length; i++) {
			int j = prices[i];
			if(prices[i]-prices[minimumIdx]>=maxSum) {
				maxSum= prices[i]-prices[minimumIdx];
			}
			if(prices[i]<prices[minimumIdx]) {
				minimumIdx = i;
			}
			
		}
		
		return maxSum;      
	  }

}
