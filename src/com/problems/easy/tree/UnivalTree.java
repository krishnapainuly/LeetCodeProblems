/**
 *
 */
package com.problems.easy.tree;


import com.problems.tree.TreeNode;

// https://leetcode.com/problems/count-univalue-subtrees/
/**
 * Given a binary tree, count the number of uni-value subtrees. A Uni-value
 * subtree means all nodes of the subtree have the same value.
 */
public class UnivalTree {
	static int count = 0;

	public static int countUnivalSubTrees(TreeNode root) {
		// Initialize
		count = 0;

		// empty tree edge case
		if (root == null) {
			return count;
		}
		bottomUpDFS(root);
		return count;
	}

	private static boolean bottomUpDFS(TreeNode node) {
		// base case if leaf node
		if (node.left == null && node.right == null) {
			count++;
			return true;
		}

		boolean bLeft = true;
		boolean bRight = true;
		boolean isUnival = false;
		// Recursion: Not a leaf node
		if (node.left != null) {
			bLeft = bottomUpDFS(node.left);
			if (node.val != node.left.val)
				bLeft = false;
		}
		if (node.right != null) {
			bRight = bottomUpDFS(node.right);
			if (node.val != node.right.val)
				bRight = false;
		}

		// Process information
		isUnival = bLeft && bRight;
		count += isUnival ? 1 : 0;
		return isUnival;
	}

	public static boolean isValidTree(TreeNode root, int value) {
		if (root == null)
			return true;

		System.out.println("left = " + root.left +
				" right = " + root.right + 
				" root = "+ root.val );
		if (!isValidTree(root.left, root.val) &&  !isValidTree(root.right, root.val))
			return false;

		count++;
		return root.val == value;
	}

	public static int univalCount(TreeNode root) {
		count = 0;
		isValidTree(root, 0);
		return count;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
//		System.out.println("DFS1 : Single valued sub trees = " + countUnivalSubTrees(root));
		System.out.println("DFS2 : Single valued sub trees = " + univalCount(root));
	}
}
