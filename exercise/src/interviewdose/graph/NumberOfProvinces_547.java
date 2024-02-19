package interviewdose.graph;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvinces_547 {

public int findCircleNum(int[][] isConnected) {
        int connectedCities = 0 ;
        int[] parentArray = new int[isConnected.length];
        Arrays.fill(parentArray, -1);
        for (int i = 0; i < parentArray.length; i++) {
			for (int j = i+1; j < parentArray.length; j++) {
				System.out.println("isConnected"+"[i]-->"+i+" [j]-->"+j +isConnected[i][j]);
				if(isConnected[i][j]==1) {
					int parentofI = findParent(parentArray, i);
					int parentofj = findParent(parentArray, j);
					if(parentofI==parentofj) {
						
					}else {
						parentArray[parentofI]=parentofj;
					}
					System.out.println("parentArray[j] "+parentArray[j]);
				}
				
			}
			
		}
        for (int i = 0; i < parentArray.length; i++) {
        	
			int j = parentArray[i];
			if(j==-1) {
				connectedCities++;
			}
		}
        return connectedCities;
    }

	int findParent(int[] parentArray,int value) {
		if(parentArray[value]==-1) {
			return value;
		}else {
			return findParent(parentArray, parentArray[value]);
		}
	}

}
