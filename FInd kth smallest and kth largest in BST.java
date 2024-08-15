SOlution 1
                                  
import java.util.*;

// Definition of TreeNode structure
// for a binary tree node
class TreeNode {
    // Value of the node
    int val;
    
    // Pointer to the left child node
    TreeNode left;
    
    // Pointer to the right child node
    TreeNode right;

    // Constructor to initialize the node with a
    // value and set left and right pointers to null
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    // Inorder traversal to populate
    // the vector with BST elements
    private void inorder(TreeNode node, List arr) {
        if (node == null) {
            return;
        }
        // Recursive call to the left subtree
        inorder(node.left, arr);
        
        // Push the value of current
        // node into the vector
        arr.add(node.val);
        
        // Recursive call to the right subtree
        inorder(node.right, arr);
        return;
    }

    // Function to find the Kth
    // smallest and largest elements in BST
    public List findKth(TreeNode node, int k) {
        // List to store the
        // elements of the BST
        List arr = new ArrayList<>();
        
        // Perform inorder traversal
        // to populate the vector
        inorder(node, arr);
        
        // Calculate Kth largest
        // and smallest elements
        int kLargest = arr.get(arr.size() - k);
        int kSmallest = arr.get(k - 1); 
        
        // Returning a list containing
        // Kth smallest and largest elements
        return Arrays.asList(kSmallest, kLargest);
    }
}

public class Main {
    // Function to perform an in-order traversal
    // of a binary tree and print its nodes
    private static void printInOrder(TreeNode root) {
        // Check if the current node
        // is null (base case for recursion)
        if (root == null) {
            // If null, return and
            // terminate the function
            return;
        }

        // Recursively call printInOrder
        // for the left subtree
        printInOrder(root.left);

        // Print the value of the current node
        System.out.print(root.val + " ");

        // Recursively call printInOrder
        // for the right subtree
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // Creating a BST
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
        
        System.out.println("Binary Search Tree: ");
        printInOrder(root);
        System.out.println();

        Solution solution = new Solution();

        // Find the Kth smallest and largest elements
        int k = 3; 
        System.out.println("k: " + k);
        List kthElements = solution.findKth(root, k);

        System.out.println("Kth smallest element: " + kthElements.get(0));
        System.out.println("Kth largest element: " + kthElements.get(1));
    }
}
                                

SOlution 2
  import java.util.ArrayList;
import java.util.List;

class Solution {
    // Brute force approach -> inorder traversal
    private void inorder(TreeNode node, List<Integer> arr){
        if(node == null) return;

        inorder(node.left, arr);
        arr.add(node.val);
        inorder(node.right, arr);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);

        int kthsmall = arr.get(k - 1);
        int kthlargest = arr.get(arr.size() - 1);

        return kthsmall;  // Assuming you want to return kth smallest
    }
}



Solution 3
                                  
import java.util.*;

// Definition of TreeNode structure
// for a binary tree node
class TreeNode {
    // Value of the node
    int val;
    
    // Pointer to the left child node
    TreeNode left;
    
    // Pointer to the right child node
    TreeNode right;

    // Constructor to initialize the node with a
    // value and set left and right pointers to null
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

class Solution {
    private void reverseInorder(TreeNode node, int[] counter, int k, int[] kLargest) {
        if (node == null || counter[0] >= k) return;

        // Traverse right subtree
        reverseInorder(node.right, counter, k, kLargest);

        // Increment counter after
        // visiting right subtree
        counter[0]++;

        // Check if current node
        // is the Kth largest
        if (counter[0] == k) {
            kLargest[0] = node.val;
            return;
        }

        // Traverse left subtree if
        // Kth largest is not found yet
        reverseInorder(node.left, counter, k, kLargest);
    }

    private void inorder(TreeNode node, int[] counter, int k, int[] kSmallest) {
        if (node == null || counter[0] >= k) return;

        // Traverse left subtree
        inorder(node.left, counter, k, kSmallest);

        // Increment counter after visiting left subtree
        counter[0]++;

        // Check if current node is the Kth smallest
        if (counter[0] == k) {
            kSmallest[0] = node.val;
            return;
        }

        // Traverse right subtree if
        // Kth smallest is not found yet
        inorder(node.right, counter, k, kSmallest);
    }

    public int[] findKth(TreeNode root, int k) {
        int[] kSmallest = new int[]{Integer.MIN_VALUE};
        int[] kLargest = new int[]{Integer.MIN_VALUE};
        // Counter to track visited nodes
        int[] counter = new int[]{0};

        // Find Kth smallest element
        // (perform inorder traversal)
        inorder(root, counter, k, kSmallest);
        
        // Reset counter for Kth largest element
        counter[0] = 0; 
        // Find Kth largest element
        // (perform reverse inorder traversal)
        reverseInorder(root, counter, k, kLargest);

        return new int[]{kSmallest[0], kLargest[0]};
    }
}

// Function to perform an in-order traversal
// of a binary tree and print its nodes
class BinaryTree {
    // Recursive function to perform in-order traversal
    private void printInOrder(TreeNode root) {
        // Check if the current node
        // is null (base case for recursion)
        if (root == null) {
            // If null, return and
            // terminate the function
            return;
        }

        // Recursively call printInOrder
        // for the left subtree
        printInOrder(root.left);

        // Print the value of the current node
        System.out.print(root.val + " ");

        // Recursively call printInOrder
        // for the right subtree
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // Creating a BST
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
        
        System.out.println("Binary Search Tree: ");
        new BinaryTree().printInOrder(root);
        System.out.println();
        
        Solution solution = new Solution();

        // Find the Kth smallest and largest elements
        int k = 3; 
        System.out.println("k: " + k);
        int[] kthElements = solution.findKth(root, k);

        System.out.println("Kth smallest element: " + kthElements[0]);
        System.out.println("Kth largest element: " + kthElements[1]);
    }
}
                                
                            
