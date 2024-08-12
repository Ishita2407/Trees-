class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root, res, ans);
        return res;
    }
    
    public static void dfs(Node root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ans){
        if(root == null) return;
        
        ans.add(root.data);
        
        if(root.left == null && root.right == null){  // leaf node
            res.add(new ArrayList<>(ans));

          // Backtracking to find the other paths
            ans.remove(ans.size() - 1);
            return;
        }
        
        dfs(root.left, res, ans);
        dfs(root.right, res, ans);
        ans.remove(ans.size() - 1);
        
    }
