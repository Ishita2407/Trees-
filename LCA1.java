import java.util.LinkedList;
import java.util.*;
public class LCA1{
    // Approach 1 - calculate the paths path1 & path2 from root to node
    // Then calculate the last common ancestor
    // Space complexity - O(n) since we have created 2 arraylists
    // Approach 2 - constant space & linear time -- only recursion stack will take O(n) space no other auxiliary space
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean getPath(Node root, int n, ArrayList<Node> path){  // O(n)
        if(root == null){
            return false;
        }
        path.add(root);
        // data found in root
        if(root.data == n){
            return true;
        }

        // Finding data in left and right subtree
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2){  
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // Storing paths from root to node -  O(n)
        getPath(root,n1,path1);
        getPath(root,n2,path2);

        // Last common ancestor - O(n)
        int i=0;
        for(; i<path1.size() &&  i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        // last equal node -> i-1th
        Node lca = path1.get(i-1);
        return lca;
    }
    public static Node lca2(Node root, int n1, int n2){
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftlca = lca2(root.left,n1,n2);
        Node rightlca = lca2(root.right,n1,n2);

        // leftlca = valid value rightlca = null
        // n1 & n2 exists is left subtree and none of them exists in right subtree
        if(rightlca == null){
            return leftlca;
        }
        if(leftlca == null){
            return rightlca;
        }

        // if none of them is null
        return root;
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n1 = 4, n2 = 7;
        System.out.println(lca2(root,n1,n2).data);
    }
}