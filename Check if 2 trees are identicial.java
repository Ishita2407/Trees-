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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if (p== null || q == null) return false;
        return ((p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}


Solution 2
                                
// Node structure for the binary tree
class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize
    // the node with a value
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class Solution {
    // Function to check if two
    // binary trees are identical
    public boolean isIdentical(Node node1, Node node2) {
        // If both nodes are NULL,
        // they are identical
        if (node1 == null && node2 == null) {
            return true;
        }
        // If only one of the nodes is
        // NULL, they are not identical
        if (node1 == null || node2 == null) {
            return false;
        }
        // Check if the current nodes
        // have the same data value
        // and recursively check their
        // left and right subtrees
        return ((node1.data == node2.data)
                && isIdentical(node1.left, node2.left)
                && isIdentical(node1.right, node2.right));
    }

    public static void main(String[] args) {
        // Node1
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        // Node2
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);

        Solution solution = new Solution();

        if (solution.isIdentical(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }
    }
}
                            
                        
