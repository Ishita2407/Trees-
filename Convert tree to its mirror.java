Given a binary tree , convert it into its mirror

class Solution{
  public static void createMirror(Node node){
    Queue<Node> q = new LinkedList<>();

    q.add(node);

    while(!q.isEmpty()){
      Node root = q.poll();

      if(root.left != null) q.add(root.left);
      if(root.right != null) q.add(root.right);

      if(root.left != null || root.right != null){
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
      }
    }
  }
}
