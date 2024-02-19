package interviewdose.greedy;

public class BestTimetoBuyandSellStockII122 {

	  public int maxProfit(int[] prices) {
			int prevMaxSum = 0;
			for (int i = 1; i <= prices.length; i++) {
				int maxSum = slideWindowAndCalculate(prices, i);
				if (maxSum >= prevMaxSum) {
					prevMaxSum = maxSum;
				}

			}
			return prevMaxSum;

		}

	int slideWindowAndCalculate(int[] prices, int windowSize) {
			int maxSum = 0;
			int windowSum = 0;
	       System.out.println("windowSize "+windowSize);
			
			for (int i = windowSize - 1; i < prices.length-windowSize; i = i + windowSize) {
				
				windowSum =  prices[i + windowSize] - prices[i];
				System.out.println("windowSum for "+i+ " -->"+windowSum+"");
				if (windowSum >0) {
					maxSum += windowSum;
				}
			}
			System.out.println("maxSum" + maxSum);
			return maxSum;
		}
}
