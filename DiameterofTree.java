import java.util.*;
public class DiameterofTree{
    // Approach 1 - time complexity O(n^2) - Bcoz we r calculating height of n nodes , TC for height of 1 node - O(n) --> TC to calc height of N nodes - O(n^2)
    // Approach 2 - Time complexity - O(N)
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int height(Node root){
        if(root == null){   // Empty tree - tree with no nodes
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;   // since parent is one level above the child node, so we add 1
    }
    public static int diameter2(Node root){  // O(N^2)
        if(root == null){   // Empty tree - tree with no nodes
            return 0;
        }
        int leftDiam = diameter2(root.left);
        int leftHt = height(root.left);   // here we r calculating left height separately
        int rightDiam = diameter2(root.right);
        int rightHt = height(root.right);   // here we r calculating right height separately
        int selfDiam = leftHt + rightHt + 1;
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));

    }
    static class Info{
        int diam;
        int ht;

        public Info (int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameter(Node root){  // Time complexity - O(n)
        // Base case
        if(root == null){
            return new Info(0,0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        // Height and diameter are being calculated simultaneously in the recursive fn
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        // returning self info in the form of an object
        return new Info(diam,ht);
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
        System.out.print("Diameter of Tree is: ");
        System.out.println(diameter(root).diam);
        // diameter(root) will return info object so to extract diameter from it we use the . operator 
        System.out.print("Height of Tree is: ");
        System.out.println(diameter(root).ht);
    }
}