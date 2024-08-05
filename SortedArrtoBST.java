public class SortedArrtoBST{
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // Time complexity - O(n)
    public static Node createBST(int arr[], int st, int end){
        // Base case
        if(st > end){
            return null;
        }
        int mid = (st + end)/2;
        Node root = new Node(arr[mid]);     // mid value of arr is made root node
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]){
        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        /*   Expected BST
                8
             5     11
           3  6  10  15
        */
        Node root = createBST(arr, 0, arr.length-1);
        preorder(root);
    }
}