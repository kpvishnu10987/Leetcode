/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();

            List<Node> level = new ArrayList<>();
            for(int i = 0 ; i<n ; i++){
                Node cur = q.poll();
                level.add(cur);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
                
            }
            int size = level.size();
            for(int i = 0 ; i<size ; i++){
                if(i+1 < size){
                    Node ne = level.get(i+1);
                    level.get(i).next = ne;
                }
            }
        }

        return root;
    }
}