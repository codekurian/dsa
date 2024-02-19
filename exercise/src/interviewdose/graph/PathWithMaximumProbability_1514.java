package interviewdose.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/path-with-maximum-probability/description/
public class PathWithMaximumProbability_1514 {

	class Pair implements Comparable<Pair> {
		int destination;
		double probability;

		public Pair(int destination, double probability) {
			this.destination = destination;
			this.probability = probability;
		}

		@Override
		public int compareTo(Pair o) {
			// max heap
			return o.destination - this.destination;
		}

	}

	public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
		Map<Integer, List<Pair>> adjacencyList = new HashMap<>();
		Map<Integer, Boolean> visited = new HashMap<>();
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		double maxProbabilty = 0;
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			double probability = succProb[i];
			Pair pair = new Pair(edge[1], probability);
			if (adjacencyList.containsKey(edge[0])) {
				List<Pair> pairList = adjacencyList.get(edge[0]);
				pairList.add(pair);
				adjacencyList.put(edge[0], pairList);
			} else {
				List<Pair> pairList = new ArrayList();
				pairList.add(pair);
				adjacencyList.put(edge[0], pairList);
			}

		}
		
		Pair startPair = new Pair(start_node, 0);
		queue.offer(startPair);
		
		while(!queue.isEmpty()) {
			Pair node = queue.remove();
			int destination = node.destination;
			double probabilty = node.probability;
			visited.put(destination, true);
			List<Pair> destinationList = adjacencyList.get(destination);
			for(int j = 0;j<destinationList.size();j++ ) {
				Pair destinationPair =  destinationList.get(j);
				int todestination= destinationPair.destination;
				double destProbability = destinationPair.probability;
				
			}
			
			
		}
		return maxProbabilty;
	}
}
