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
        if(map.containsKey(node)) return map.get(node);
        if(node == null) return null;

        Node clone = new Node(node.val);
        map.put(node,clone);
        for(Node nei : node.neighbors){
            map.put(nei,cloneGraph(nei));
        }

        List<Node> neigh = new ArrayList<>();

        for(Node nei : node.neighbors){
            clone.neighbors.add(map.get(nei));
        }

        return clone;
        
    }
}