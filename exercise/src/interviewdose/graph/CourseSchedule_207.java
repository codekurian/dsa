package interviewdose.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/course-schedule/description/
public class CourseSchedule_207 {
	class Solution {
		   
		 public boolean canFinish(int numCourses, int[][] prerequisites) {
		        boolean canFinish = true;
		        Map<Integer,List<Integer>> graph = new HashMap<>();
		        Stack<Integer>path = new Stack<>();
		        for (int i = 0; i < prerequisites.length; i++) {
					int[] js = prerequisites[i];
					int leftNode = js[0];
					int rightNode = js[1];
					
					addToAdjacencyList(graph, leftNode, rightNode);
					//addToAdjacencyList(graph, rightNode, leftNode);
					
					
				}
		        System.out.println("graph "+graph);
		        int [] visitedArray = new int[numCourses];
		        for (int i = 0; i < visitedArray.length; i++) {
		        	visitedArray[i] = 0;
					
				}
		        // create an adjacency list
		        for(int i = 0 ;i<visitedArray.length;i++) {
		        	if(visitedArray[i]!=1) {
		        		if(isCyclic(graph, i, visitedArray))
		        		{
		        			return false;
		        		}
		        		
		        	}
		        	
		        
		        }
		      
		      
		        
		        
		        return canFinish;
		    }

		private void addToAdjacencyList(Map<Integer, List<Integer>> graph, int leftNode, int rightNode) {
			if(graph.containsKey(leftNode)) {
				graph.get(leftNode).add(rightNode);
			}else {
				List<Integer> adjacencyList = new ArrayList<>();
				adjacencyList.add(rightNode);
				graph.put(leftNode, adjacencyList);
			}
			if(!graph.containsKey(rightNode)) {
				List<Integer> adjacencyList = new ArrayList<>();
				graph.put(rightNode, adjacencyList);
			}
		}
		 
		 public void dfs( Map<Integer,List<Integer>> graph,int node, int [] visitedArray,Stack<Integer>path) {
			 
				 visitedArray[node] = 2;
				 List<Integer> adjacencyList = graph.get(node);
				 if(null!= adjacencyList) {
					 for (int i = 0; i < adjacencyList.size(); i++) {
							int nextNode = adjacencyList.get(i);
							if(visitedArray[node]==1) {
								dfs(graph, nextNode, visitedArray,path);
								visitedArray[node]=1;
							}
							
						}
					 path.add(node);
				 }
				 
			 }
	public boolean isCyclic( Map<Integer,List<Integer>> graph,int node, int [] visitedArray) {
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
					
					System.out.println("[node]-->"+node);
					boolean isCyclic = isCyclic(graph, nextNode, visitedArray);
					
					if(isCyclic) {
						return isCyclic;
					}
					
				}
	            visitedArray[node]=2;
			
		 }
		 return false;

	} 
	}
}
