import java.util.*;
public class KthLargestSmallestBST{
    // Time complexity- O(min(K,N))
    // Space complexity - O(min(K,N))
    // Find the kth smallest and largest element in BST
    class Node{
        int data;
        Node left, right;

        Node(int value){
            data = value;
            left = null;
            right = null;
        }
    }

    static Node kthLargest(Node root, int k[]){
        if(root == null) return null;

        Node right = kthLargest(root.right, k);
        if(right != null) return right;
        k[0]--;

        if(k[0] == 0) return root;
        return kthLargest(root.left, k);
    }

    static Node kthSmallest(Node root, int k[]){
        if(root == null) return null;

        Node left = kthSmallest(root.left, k);
        if(left != null) return left;

        k[0]--;
        if(k[0] == 0) return root;
        return kthSmallest(root.right, k);
    }
}