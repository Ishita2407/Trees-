144. Binary Tree Preorder Traversal
Given the root of a binary tree, return the preorder traversal of its nodes' values.

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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList <Integer> preOrder = new ArrayList <Integer> ();
        TreeNode curr = root;

        if (curr == null)
            return preOrder;

        Stack <TreeNode> s = new Stack <>();
        s.push(curr);

        while (!s.isEmpty()) {
            TreeNode topNode = s.peek();
            preOrder.add(topNode.val);
            s.pop();
            if (topNode.right != null)
                s.push(topNode.right);
            if (topNode.left != null)
                s.push(topNode.left);
        }
        return preOrder;
    }

}
