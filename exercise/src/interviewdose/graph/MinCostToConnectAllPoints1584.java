package interviewdose.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//https://leetcode.com/problems/min-cost-to-connect-all-points/description/
public class MinCostToConnectAllPoints1584 {

	class Pair implements Comparable<Pair> {
		int x;
		int y;
		int weight;

		public Pair(int x,int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Pair o) {
			Pair obj = (Pair) o;
			return this.weight - obj.weight;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Pair other = (Pair) obj;
			if (x != other.x) {
				return false;
			}
			if (y != other.y) {
				return false;
			}
			return true;
		}

		private MinCostToConnectAllPoints1584 getOuterType() {
			return MinCostToConnectAllPoints1584.this;
		}
		

	}

	public int minCostConnectPoints(int[][] points) {
		Map<Pair, List<Pair>> adjacencyList = new HashMap<>();
		Map<Integer, Integer> visited = new HashMap<>();
		
		int sum=0;
		for (int i = 0; i < points.length; i++) {
			List<Pair> pairs = new ArrayList<>();
			int[] coordinates = points[i];

			int x = coordinates[0];
			int y = coordinates[1];
			Pair pairKey = new Pair(x, y, 0);
			for (int j = i + 1; j < points.length; j++) {
				int[] coordinates2 = points[j];
				int x2 = coordinates2[0];
				int y2 = coordinates2[1];
				int manhattanWeight = Math.abs(x2 - x) + Math.abs(y2 - y);
				Pair pair = new Pair(x2,y2, manhattanWeight);
				pairs.add(pair);

			}
			adjacencyList.put(pairKey, pairs);

		}
		System.out.println(adjacencyList);
		
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		// adding first element to the queue
		
		if (points.length > 0) {
			Pair p = new Pair(points[0][0],points[0][1], 0);
			queue.offer(p);
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				Pair tobeProcessed = queue.remove();
				Integer key = tobeProcessed.x;
				if (!visited.containsKey(key)) {
					List<Pair> pairs = adjacencyList.get(tobeProcessed);
					for (int k = 0; k < pairs.size(); k++) {
						Pair pair = pairs.get(k);
						queue.offer(pair);
					}
					visited.put(key, tobeProcessed.weight);
					sum+=tobeProcessed.weight;
				}
			}

		}
		
		return sum;

	}
}
