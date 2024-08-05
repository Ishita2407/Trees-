import java.util.LinkedList;
import java.util.ArrayList;
public class DeleteinBST{
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
    public static Node delete(Node root, int val){
        if(root.data < val){
            root.right = delete(root.right,val);
        }
        else if(root.data > val){
            root.left = delete(root.left, val);
        }
        else{
            // case 1 - leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            // case 2 - single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            // case 3 - both children exists
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    // Print Nodes in range 
    public static void printInRange(Node root, int k1, int k2){
        // Base case
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } 
        // Nodes lie in the left subtree
        else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }
        // Nodes lie in right subtree
        else{
            printInRange(root.right, k1, k2);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i<path.size(); i++){
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println("Null");
    }
    // Print nodes from root to leaf
    public static void printRoot2leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        // When we have reached the leaf node -> print it
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2leaf(root.left, path);    // left subtree
        printRoot2leaf(root.right, path);   // right subtree
        // Remove current root
        path.remove(path.size()-1);
    }
    public static void main(String args[]){
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for(int i=0; i<values.length; i++){
            root = insert(root,values[i]);
        }
        inorder(root);
        System.out.println();

        printRoot2leaf(root, new ArrayList<>());
    }
}
