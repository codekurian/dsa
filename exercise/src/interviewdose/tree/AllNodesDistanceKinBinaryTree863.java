package interviewdose.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
public class AllNodesDistanceKinBinaryTree863 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> nodeWithDistancek = new ArrayList<Integer>();
		Map<Integer, TreeNode> parentMap = buildParentMap(root);
		Map<TreeNode,Boolean> traversedNode = new HashMap();
		Queue<TreeNode> levelOrderQueue = new LinkedList<TreeNode>();
		levelOrderQueue.offer(target);
		
		int level = 0;
		while (!levelOrderQueue.isEmpty()) {
			level++;
			if(level==k) {
				break;
			}
			for (int i = 0; i < levelOrderQueue.size(); i++) {
				System.out.println("levelOrderQueue.size()"+levelOrderQueue.size());
				TreeNode node = levelOrderQueue.poll();
				TreeNode parentOfTarget = parentMap.get(node.val);
				traversedNode.put(target, true);
				if (null != parentOfTarget) {
					
					if (!traversedNode.get(parentOfTarget)) {
						traversedNode.put(parentOfTarget,true);
						levelOrderQueue.offer(parentOfTarget);
					}
				}
				if (null != node.left) {
					
					if (!traversedNode.get(node.left)) {
						traversedNode.put(node.left,true);
						levelOrderQueue.offer(node.left);
					}
				}
				if (null != node.right) {
					if (!traversedNode.get(node.right)) {
						traversedNode.put(node.right,true);
						levelOrderQueue.offer(node.right);
					}
				}

			}
			
			
		}
		while (!levelOrderQueue.isEmpty()) {
			TreeNode node = levelOrderQueue.poll();
			nodeWithDistancek.add(node.val);
		}

		return nodeWithDistancek;
	}
	
	public Map<Integer, TreeNode> buildParentMapWithoutRecursion(TreeNode node) {
		Map<Integer, TreeNode> parentMap = new HashMap<Integer, TreeNode>();
		Queue<TreeNode>q=new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            TreeNode cur=q.poll();

            if(cur.left!=null){
            	parentMap.put(cur.left.val,cur);
                q.add(cur.left);
            }

            if(cur.right!=null){
            	parentMap.put(cur.right.val,cur);
                q.add(cur.right);
            }
        }
		
		return parentMap;
	}

	public Map<Integer, TreeNode> buildParentMap(TreeNode node) {
		Map<Integer, TreeNode> parentMap = new HashMap<Integer, TreeNode>();
		preordeTraversal(node, parentMap);
		System.out.println(parentMap);
		return parentMap;
	}

	public void preordeTraversal(TreeNode node, Map<Integer, TreeNode> parentMap) {
		if (node == null) {
			return;
		} else {
			if (node.left != null) {
				parentMap.put(node.left.val, node);
			}
			preordeTraversal(node.left, parentMap);
			if (node.right != null) {
				parentMap.put(node.right.val, node);
			}

			preordeTraversal(node.right, parentMap);
		}
	}
}
