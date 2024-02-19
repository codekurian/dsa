package interviewdose.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/course-schedule-ii/description/
public class CourseSchedule210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		Stack<Integer> path = new Stack<>();
		int [] result = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int[] js = prerequisites[i];
			int leftNode = js[0];
			int rightNode = js[1];

			addToAdjacencyList(graph, leftNode, rightNode);
		

		}
		int[] visitedArray = new int[numCourses];
		for (int i = 0; i < visitedArray.length; i++) {
			visitedArray[i] = 0;

		}
		
		 for(int i = 0 ;i<visitedArray.length;i++) {
	        	if(visitedArray[i]!=1) {
	        		if(isCyclic(graph, i, visitedArray,path))
	        		{
	        			return result;
	        		}
	        		
	        	}
	        	
	        
	        }
		 int i = numCourses-1;
		 while(!path.isEmpty()) {
			 result[i--]=path.pop();
		 }
		 
		 return result;
	}

	private void addToAdjacencyList(Map<Integer, List<Integer>> graph, int leftNode, int rightNode) {
		if (graph.containsKey(leftNode)) {
			graph.get(leftNode).add(rightNode);
		} else {
			List<Integer> adjacencyList = new ArrayList<>();
			adjacencyList.add(rightNode);
			graph.put(leftNode, adjacencyList);
		}
		if (!graph.containsKey(rightNode)) {
			List<Integer> adjacencyList = new ArrayList<>();
			graph.put(rightNode, adjacencyList);
		}
	}
	
	public boolean isCyclic( Map<Integer,List<Integer>> graph,int node, int [] visitedArray,Stack<Integer> path) {
		 if(visitedArray[node]==1) {
			 return true;
		 }
		 if(visitedArray[node]==2) {
			 
			 return false;
		 }
		 visitedArray[node]=1;
		 
		 List<Integer> adjacencyList = graph.get(node);
		 if(null!= adjacencyList) {
			 for (int i = 0; i < adjacencyList.size(); i++) {
					int nextNode = adjacencyList.get(i);
					
					boolean isCyclic = isCyclic(graph, nextNode, visitedArray,path);
					
					if(isCyclic) {
						return isCyclic;
					}
					
				}
	            visitedArray[node]=2;
	            path.push(node);
			
		 }
		 return false;

	} 
}
