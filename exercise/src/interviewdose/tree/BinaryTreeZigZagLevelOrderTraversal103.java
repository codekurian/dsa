package interviewdose.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagLevelOrder = new LinkedList<List<Integer>>();
        LinkedList<TreeNode>levelQueue = new LinkedList<>();
        if(root!=null) {
        	List<Integer> rootNodeList = new ArrayList<>();
			rootNodeList.add(root.val);
			zigzagLevelOrder.add(rootNodeList);
        	levelQueue.offer(root);
        }
        traverseZigZagLevelOrder(levelQueue, zigzagLevelOrder);
        return zigzagLevelOrder;
    }
	
	public void traverseZigZagLevelOrder(LinkedList<TreeNode>levelQueue,List<List<Integer>> zigzagLevelOrder) {
		int levelCount = 0;
		while(!levelQueue.isEmpty()) {
			int levelSize = levelQueue.size();
			List<Integer> levelNodes = new LinkedList<Integer>();
			levelCount++;
			for(int i = 0;i<levelSize;i++) {
				TreeNode node ;
				if(levelCount%2==1) {
					node = levelQueue.poll();
				}else {
					node = levelQueue.pollLast();
				}
				
				if(node!=null) {
					
					if(levelCount%2==1) {
						
						if(node.right!=null) {
							levelQueue.offer(node.right);
							levelNodes.add(node.right.val);
						}
						if(node.left!=null) {
							levelNodes.add(node.left.val);
							levelQueue.offer(node.left);
						}
					}else {
						if(node.left!=null) {
							levelNodes.add(node.left.val);
							levelQueue.offer(node.left);
						}
						if(node.right!=null) {
							levelQueue.offer(node.right);
							levelNodes.add(node.right.val);
						}
					}
					
					
					
				}
			}
			if(!levelNodes.isEmpty()) {
				zigzagLevelOrder.add(levelNodes);
			}
			
			
			
		}
	}

}
