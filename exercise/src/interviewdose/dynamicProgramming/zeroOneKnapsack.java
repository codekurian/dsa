package interviewdose.dynamicProgramming;

import java.util.Arrays;

public class zeroOneKnapsack {
 int profit = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	 public int solveKnapsack(int[] profits, int[] weights, int capacity) {
		    int n = weights.length;
		    // TODO: Write your code here
		    int[][] dp = new int[n+1][capacity+1];
		    for(int[] row :dp){
		      Arrays.fill(row, -1);
		    }
		    
		    return recursiveKnapsack(profits,weights,capacity,n,dp);
		  }

		  public int recursiveKnapsack(int[] profits, int[] weights, int capacity,int index,int dp[][]) {
		   
		    // TODO: Write your code here
		    if(index == 0 || capacity==0 ){
		      return 0;
		    }
		    if(dp[index-1][capacity] != -1){
		      return dp[index-1][capacity];
		    }
		    if(weights[index-1]>capacity){
		       int profitNotIncluded = recursiveKnapsack(profits,weights,capacity,index-1,dp);
		       dp[index-1][capacity] = profitNotIncluded;
		        return   dp[index-1][capacity];
		     
		    }else{
		      int profitNotIncluded = recursiveKnapsack(profits,weights,capacity,index-1,dp);
		      int profitIncluded = profits[index-1] + recursiveKnapsack(profits,weights,capacity-weights[index-1],index-1,dp);

		      dp[index-1][capacity] = Math.max(profitNotIncluded,profitIncluded);
		      return  dp[index-1][capacity] ;
		    }
		    
		  }

}
