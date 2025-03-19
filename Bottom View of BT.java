

//User function Template for Java

class Pair{
    Node node;
    int line;
    
    Pair(Node node, int line){
        this.node = node;
        this.line = line;
    }
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null) {
            return ans;
        }
        
        // Map to store the bottom view nodes
        Map<Integer, Integer> mpp = new TreeMap<>();
        
        // Queue for BFS traversal, each
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0));
        
        // BFS traversal
        while(!q.isEmpty()) {
            // Retrieve the node and its vertical
            // position from the front of the queue
            Pair pair = q.poll();
            Node node = pair.node;
            int line = pair.line;
            
            // Update the map with the node's data
            // for the current vertical position
            mpp.put(line, node.data);
            
            // Process left child
            if(node.left != null) {
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new Pair(node.left, line - 1));
            }
            
            // Process right child
            if(node.right != null) {
                // Push the right child with an increased
                // vertical position into the queue
                q.add(new Pair(node.right, line + 1));
            }
        }
        
        // Transfer values from the
        // map to the result list
        for (int value : mpp.values()) {
            ans.add(value);
        }
        return ans;
    }
}
