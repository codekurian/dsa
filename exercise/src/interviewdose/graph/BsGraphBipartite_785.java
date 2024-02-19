package interviewdose.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BsGraphBipartite_785 {

	// https://leetcode.com/problems/is-graph-bipartite/
	class Solution {
		public boolean isBipartite(int[][] graph) {

			int[] colorArray = new int[graph.length];
			boolean[] visitedArray = new boolean[graph.length];

			// non visited array = 0
			for (int i = 0; i < colorArray.length; i++) {
				colorArray[i] = 0;
				visitedArray[i]=false;

			}
			Queue<Integer> queue = new LinkedList<Integer>();

			for (int i = 0; i < graph.length; i++) {
				if (!visitedArray[i]) {
					queue.offer(i);
					
					colorArray[i] = -1;
					
					if (!bfs(graph, colorArray, 1, queue,visitedArray)) {
						return false;
					}
				}
			}

			return true;
		}
		// A graph is bipartite if there are no edges to nodes in the same set

		public boolean bfs(int[][] graph, int[] colorArray, int toBeColored, Queue<Integer> queue,boolean[] visited) {
			
			if (!queue.isEmpty()) {
				int size = queue.size();
				
				for (int i = 0; i < size; i++) {
					int node = queue.poll();
					
					System.out.println("node-->"+node);
					
					int[] adjacencyArray = graph[node];
					//System.out.println(adjacencyArray.length);
					
					//toBeColored = currentNodeColor*-1;
					for (int j = 0; j < adjacencyArray.length; j++) {
						System.out.println("visited "+adjacencyArray[j]+"->"+visited[adjacencyArray[j]]);
						
						if(!visited[adjacencyArray[j]]) {
							if(colorArray[adjacencyArray[j]]==0) {
								queue.offer(adjacencyArray[j]);
							}
							
							
							
							int currentNodeColor = colorArray[adjacencyArray[j]];
							System.out.println("current color -->"+currentNodeColor);
							System.out.println("toBeColored color -->"+toBeColored*-1);
							if(currentNodeColor==toBeColored*-1) {
								return false;
							}
							colorArray[adjacencyArray[j]] = toBeColored*-1;
							
						}
						
					 
					}
					System.out.println("queue "+queue);
					visited[node] = true;
					
				}
				
				bfs(graph, colorArray, toBeColored*-1, queue,visited);


			}else {
				return true;
			}

			return true;

		}

	}
}
