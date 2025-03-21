
class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        
        int ceil = -1;
        while(root != null){
            if(key == root.data){
                ceil = root.data;
                return ceil;
            }
            
            if(root.data < key){
                root = root.right;
            }
            else{
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}
