/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // Base case 
        if(root == null) return 0;

        int lh = maxDepth(root.left); // calculating left subtree
        int rh = maxDepth(root.right); // calculating height of right subtree

        return Math.max(lh, rh) + 1;
    }
}
