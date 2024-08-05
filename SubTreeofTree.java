import java.util.*;
public class SubTreeofTree{
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isIdentical(Node node, Node subRoot){
        // Checking violation conditions --> Non - identical
        if(node == null && subRoot == null){    // Identical
            return true;   
        }
        // If either one of them is null or data of node != data of subroot
        else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }
        // Non- identical nodes in left subtree
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        // Non- identical nodes in right subtree
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;    // All other cases- Identical
    }
    
    public static boolean isSubtree(Node root, Node subRoot){
        // Base case
        if(root == null){
            return false;
        }
        // Checking where does the subRoot lies in the main tree
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        // Checking for the subRoot in left and right subtree
        // Returns true if subRoot is found else false
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static void main(String args[]){
        /*    1
            2   3
         4  5  6  7     Full binary tree
        
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*      2
              4   5
        */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        System.out.println(isSubtree(root, subRoot));
    }
}