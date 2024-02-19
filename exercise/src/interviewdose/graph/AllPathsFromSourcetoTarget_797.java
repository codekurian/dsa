package interviewdose.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/all-paths-from-source-to-target/description/
public class AllPathsFromSourcetoTarget_797 {

	 public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
			Map<Integer,Integer> visitedMap = new HashMap<>();
			List<List<Integer>> paths = new LinkedList<List<Integer>>();
			LinkedList<Integer> path = new LinkedList<>();
	        path.addLast(0);
			dfs(graph, 0, paths,path, visitedMap);
			
			return paths;
		    }
		 
		 public void dfs(int[][] graph,int node,List<List<Integer>> paths,LinkedList<Integer> path ,Map<Integer,Integer> visitedMap){
			
			 //base case when the currentNode has reached the len
			 if(node == graph.length-1) {
				paths.add(new LinkedList<>(path));
				return;
			 }
			    
			   // visitedMap.put(node, node);
			   
			    int[] neighbours = graph[node];
				for (int j = 0; j < neighbours.length; j++) {
					int nextTobeExplored = neighbours[j];
	                System.out.println("nextTobeExplored -->"+nextTobeExplored);
					 path.addLast(nextTobeExplored);
					 dfs(graph, nextTobeExplored, paths, path, visitedMap);
					path.removeLast();
					
					
					
				}
			
					 
		 }
	
}
