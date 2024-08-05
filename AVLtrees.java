public class AVLtrees{
    static class Node{
        int data, height;
        Node left,right;

        Node(int data){
            this.data = data;
            height = 1;
        }
    }
    public static Node root;
    
    // Function to return height for a root 
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }
    static int max(int a, int b){
        return (a > b) ? a : b;
    }

    // Get Balance factor of node
    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;        // x becomes left child of y
        x.right = T2;      // T2 becomes right child of x

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // return new root
        return y;
    }

    public static Node rightRotate(Node y){
        Node x = y.left;    // y is root node , x is left child of y
        Node T2 = x.right;      // T2 is right child of x

        // Perform rotation
        x.right = y;        // y is made right child of x
        y.left = T2;       // T2 is left child of y

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;

    }
    public static Node insert(Node root, int key){
        if(root == null){
            return new Node(key);
        }

        // Inserting node in left subtree if key < root.data
        if(key < root.data){
            root.left = insert(root.left, key);
        }

        // inserting node in right subtree if key > root.data
        else if(key > root.data ){
            root.right = insert(root.right, key);
        }
        else{   // when key = root.data
            return root;    // Duplicate keys not allowed
        }
        // update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get root's balance factor
        int bf = getBalance(root);

        // left left case
        if(bf > 1 && key < root.left.data){
            return rightRotate(root);
        }

        // Right right case
        if(bf < -1 && key > root.right.data){
            return leftRotate(root);
        }

        // Left right case
        if(bf > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right left case
        if(bf < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root; // returned if AVL balanced
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
        root = insert(root,10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*      30
             20     40 
          10   25      50
        */
        preorder(root);
    }
}