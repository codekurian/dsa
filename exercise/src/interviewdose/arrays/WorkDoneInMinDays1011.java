package interviewdose.arrays;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class WorkDoneInMinDays1011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weights = new int[] {1,2,3,4,5,6,7,8,9,10};
		int days = 5;
		System.out.println(shipWithinDays(weights, days));
		
	}

	
	 public static int shipWithinDays(int[] weights, int days) {
		 long maxCapacityOfShip =0;
		 long minCapacityOfShip = Long.MIN_VALUE;
		 for (int i = 0; i < weights.length; i++) {
			 maxCapacityOfShip+=weights[i];
			 if(minCapacityOfShip<=weights[i]) {
				 minCapacityOfShip = weights[i];
			 }	
		}
		 return (int) concur(weights, days, maxCapacityOfShip,minCapacityOfShip, maxCapacityOfShip);
	    }
	 private static long concur(int[] weights, int days,long maxCapacityOfShip ,long low,long high) {

		
		int midWeight = (int) partition(low,high);
		
	    if(low>high) {
	    	return maxCapacityOfShip;
	    }else {
	    	
	    	if(!possible(weights, days, midWeight)) {
	    		//if mid solves it we have option to go higher or lower
	    		//find the between numbers
	    
	    		return concur(weights, days,maxCapacityOfShip, midWeight+1,high);
	    		
	    		
	    	}else {
	    		maxCapacityOfShip = midWeight;
	    		return concur(weights, days,maxCapacityOfShip, low, midWeight-1);
	    	}
	    	
	    	
	    }
	    
	    
	 }

	 // A method which will tell if we can s
	private static boolean possible(int[] weights, int days,int midWeight) {
		int daysUsed = 1 ;
		int capacity = 0;
	
		
			//days has to be consumed and capacity has to be less than equal to midweight
			for (int i = 0; i < weights.length; i++) {
				if((weights[i]+capacity)<=midWeight) {
					
					capacity += weights[i];
				}else {
					capacity=weights[i];
					daysUsed++;
					
				}
			}
			if(daysUsed<=days) {
				return true;
			}else {
				return false;
			}
			
		
		
	}


	private static long partition(long low, long high) {
		
		return low+((high-low)/2);
	}
	 
	 
}
