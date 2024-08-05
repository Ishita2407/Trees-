import java.util.*;
class NodeValue{
    public int maxNode, minNode, maxSize;
    
    NodeValue(int maxNode, int minNode, int maxSize){
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}
public class SizeOfLargestBST{
    public NodeValue LargestSubtreeHelper(TreeNode root){
        // Post order traversal
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE, Intger.MIN_VALUE, 0);
        }

        // Get values from left and right 
        NodeValue left = LargestSubtreeHelper(root.left);
        NodeValue right = LargestSubtreeHelper(root.right);

        // If greatest of left is less than root and smallest of right is greater than root -> valid bst
        if(left.maxNode < root.val && root.val < right.minNode){
            // Valid BST
            return new NodeValue(Math.min(root.val , left.minNode), Math.max(root.val, right.maxNode), left.maxSize + right.maxSize + 1);   
        } else{
            // Not a valid BST
            // add -infinity, infinity , max of size of left/right
            // We can get the size , but min and max node are given 
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
        }
    }

    public int largestBST(TreeNode root){
        return LargestSubtreeHelper(root).maxSize;
    }
}