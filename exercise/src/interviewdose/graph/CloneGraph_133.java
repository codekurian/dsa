package interviewdose.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/clone-graph/description/

//Definition for a Node.
class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class CloneGraph_133 {

	public Node cloneGraph(Node node) {
		
		Map<Node,Node>visitedNode = new HashMap<>();
		
		return dfs(node, visitedNode);
	}

	public Node dfs(Node node,Map<Node,Node>visitedNode) {
		
		if(node==null) {
			return node;
		}
		if(visitedNode.containsKey(node)) {
			return visitedNode.get(node);
		}else {
			Node clonedNode = new Node(node.val);
			visitedNode.put(node, clonedNode);
			List<Node> neighbours  = node.neighbors;
			for (Node neighbourNode : neighbours) {
				Node returnedNode =  dfs(neighbourNode, visitedNode);
				clonedNode.neighbors.add(returnedNode);
				
				
			}
			
			return visitedNode.get(node);
		}
	}
}
