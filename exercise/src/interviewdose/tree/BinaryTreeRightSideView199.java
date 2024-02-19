package interviewdose.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/description/
public class BinaryTreeRightSideView199 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightSideNodes = new ArrayList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		if (root != null) {

			rightSideNodes.add(root.val);

		}

		rightSideView(queue, rightSideNodes);
		return rightSideNodes;

	}

	public void rightSideView(LinkedList<TreeNode> levelQueue, List<Integer> rightSideNodes) {

		while (!levelQueue.isEmpty()) {
			int levelSize = levelQueue.size();
			List<Integer> levelNodes = new LinkedList<Integer>();

			for (int i = 0; i < levelSize; i++) {
				TreeNode levelNode = levelQueue.poll();

				if (levelNode != null) {

					if (levelNode.left != null) {
						levelNodes.add(levelNode.left.val);
						levelQueue.offer(levelNode.left);
					}
					if (levelNode.right != null) {
						levelQueue.offer(levelNode.right);
						levelNodes.add(levelNode.right.val);
					}

				}
			}
			if (!levelNodes.isEmpty()) {
				rightSideNodes.add(levelNodes.get(levelNodes.size() - 1));
			}

		}
	}

}
