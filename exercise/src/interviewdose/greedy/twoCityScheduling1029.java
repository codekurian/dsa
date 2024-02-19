package interviewdose.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/two-city-scheduling/description/
public class twoCityScheduling1029 {

	
public int twoCitySchedCost(int[][] costs) {
	
	//Arrays.sort(costs);
	int cost = 0;
	
	
	for (int i = 0; i < costs.length; i++) {
		int[] js = costs[i];
		int destinationA = js[0];
		int destinationB = js[1];
		System.out.println("destinationA-->"+destinationA);
		System.out.println("destinationB-->"+destinationB);
		int absValue = Math.abs(destinationA-destinationB);
		cost+=absValue;
		
		
	}
 return cost;

    }
}
