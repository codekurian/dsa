package interviewdose.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
//https://leetcode.com/problems/binary-tree-right-side-view/
public class BinaryTreeLevelOrderTraversal102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<>(); 
		queue.offer(root);
		if (root != null) {
			List<Integer> rootNodeList = new ArrayList<>();
			rootNodeList.add(root.val);
			levelOrderList.add(rootNodeList);
		}

		addChildren(queue, levelOrderList);
	        return levelOrderList;

	}


	public void addChildren(LinkedList<TreeNode>levelQueue,List<List<Integer>> zigzagLevelOrder) {
		
		while(!levelQueue.isEmpty()) {
			int levelSize = levelQueue.size();
			List<Integer> levelNodes = new LinkedList<Integer>();
		
			for(int i = 0;i<levelSize;i++) {
				TreeNode levelNode = levelQueue.poll();
				
				if(levelNode!=null) {
					
					 
						if(levelNode.left!=null) {
							levelNodes.add(levelNode.left.val);
							levelQueue.offer(levelNode.left);
						}
						if(levelNode.right!=null) {
							levelQueue.offer(levelNode.right);
							levelNodes.add(levelNode.right.val);
						}
					
					
					
					
				}
			}
			if(!levelNodes.isEmpty()) {
				zigzagLevelOrder.add(levelNodes);
			}
			
			
			
		}
	}
	
   public void rightSideView(LinkedList<TreeNode>levelQueue,List<Integer> rightSideNodes) {
		
		while(!levelQueue.isEmpty()) {
			int levelSize = levelQueue.size();
			List<Integer> levelNodes = new LinkedList<Integer>();
		
			for(int i = 0;i<levelSize;i++) {
				TreeNode levelNode = levelQueue.poll();
				
				if(levelNode!=null) {
					
					 
						if(levelNode.left!=null) {
							levelNodes.add(levelNode.left.val);
							levelQueue.offer(levelNode.left);
						}
						if(levelNode.right!=null) {
							levelQueue.offer(levelNode.right);
							levelNodes.add(levelNode.right.val);
						}
					
					
					
					
				}
			}
			if(!levelNodes.isEmpty()) {
				rightSideNodes.add(levelNodes.get(levelNodes.size()-1));
			}
			
			
			
		}
	}
}
