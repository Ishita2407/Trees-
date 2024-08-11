class Solution{
  public static int isSumProperty(Node root){
        if(helper(root)) return 1;
        return 0;
    }
    
    private static boolean helper(Node root){
        if(root == null) return true;    
        
        if(root.left == null && root.right == null) return true;
        
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        
        int leftData = (root.left != null) ? root.left.data : 0;
        int rightData = (root.right != null) ? root.right.data : 0;
        
        return left && right && (leftData + rightData == root.data);
    }
}
