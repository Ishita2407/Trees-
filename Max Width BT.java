Solution 1 
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    class Node {
        TreeNode node;
        int idx;
        Node(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root,0));
        int max = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            int start = 0, end = 0;
            for(int i=0; i<size; i++)
            {
                Node eachNode = queue.remove();
                int index = eachNode.idx; 
                if(i==0) 
                    start = index; //start and end index for each level
                
                if(i==size-1) 
                    end = index;
                
                if(eachNode.node.left!=null)
                    queue.add(new Node(eachNode.node.left, 2*eachNode.idx));

                if(eachNode.node.right!=null)
                    queue.add(new Node(eachNode.node.right, 2*eachNode.idx+1));
                
            }
            max = Math.max(max, end - start + 1);
        }
        return max;    
    }
}

Solution 2
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    class Node {
        TreeNode node;
        int idx;
        Node(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root,0));
        int max = 0;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            int start = 0, end = 0;
            for(int i=0; i<size; i++)
            {
                Node eachNode = queue.remove();
                int index = eachNode.idx; 
                if(i==0) 
                    start = index; //start and end index for each level
                
                if(i==size-1) 
                    end = index;
                
                if(eachNode.node.left != null)
                    // left child is at index 2*i + 1 if parent is at idx i
                    queue.add(new Node(eachNode.node.left, 2*eachNode.idx + 1));

                if(eachNode.node.right!=null)
                // right child is at index 2*i + 2 if parent is at idx i
                    queue.add(new Node(eachNode.node.right, 2*eachNode.idx + 2));
                
            }
            max = Math.max(max, end - start + 1);
        }
        return max;    
    }
}
