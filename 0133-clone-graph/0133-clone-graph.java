/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node cur = q.poll();

            Node clone = new Node(cur.val);
            map.put(cur,clone);

            for(Node nei : cur.neighbors){
                if(!map.containsKey(nei)){
                    q.offer(nei);
                }
            }
        }

        q.offer(node);
        Set<Node> vis = new HashSet<>();
        vis.add(node);

        while(!q.isEmpty()){
            Node cur = q.poll();
            Node clone = map.get(cur);
            

            for(Node nei: cur.neighbors){
                clone.neighbors.add(map.get(nei));
                if(!vis.contains(nei)){
                    vis.add(nei);
                    q.offer(nei);
                }
                
            }
        }



        return map.get(node);
    }
}