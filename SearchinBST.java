import java.util.LinkedList;
public class SearchinBST{
    // Time complexity - O(H) H- height of tree
    // Worst case TC- O(n) when we have skewed trees (when we have to traverse from root to leaf node)
    // Best case Tc
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            // New node is made root 
            root = new Node(val);
            return root;
        }
        // If root is not null
        if(root.data > val){
            // left subtree
            root.left = insert(root.left,val);
        } else{
            // right subtree
            root.right = insert(root.right,val);
        }
        return root;
    }
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        } 
        if(root.data > key){
            return search(root.left, key);
        }
        else{
            return search(root.right,key);
        }
    }
    public static void main(String args[]){
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        for(int i=0; i<values.length; i++){
            root = insert(root,values[i]);
        }
        System.out.println();
        if(search(root,1)){
           System.out.print("Key found");
        } else{
            System.out.println("Key not found");
        }
    }
}