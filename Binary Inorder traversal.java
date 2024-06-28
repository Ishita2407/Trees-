94. Binary Tree Inorder Traversal
Given the root of a binary tree, return the inorder traversal of its nodes' values.

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

  Solution 1
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
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> inorder = new ArrayList<Integer>();

       TreeNode curr = root;
       while(curr != null){
           if(curr.left == null){  // no left subtree
               inorder.add(curr.val);  // add val of curr in arraylist
               curr = curr.right; // move to right child
           } else{
               // curr.left is not null
               TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                   prev = prev.right;
                }
                if(prev.right == null){
                    // set rightmost child to curr and move to left of curr
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null; // break the thread
                    inorder.add(curr.val);
                    curr = curr.right;
                }
           }
       }
       return inorder;
    }
}


Solution 2
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> s = new Stack<TreeNode>();

        TreeNode curr = root;
        while(true){
            if(curr != null){
                s.push(curr);
                curr = curr.left;
            }else{
                if(s.isEmpty()) break;
                curr = s.peek();
                inorder.add(curr.val);
                s.pop();
                curr = curr.right;
            }
        }
        return inorder;
    }
}
