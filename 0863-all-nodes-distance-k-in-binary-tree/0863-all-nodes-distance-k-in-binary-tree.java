/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildparent(root, null, parent);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        q.offer(target);
        vis.add(target);
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (dist == k) {
                while (!q.isEmpty()) {
                    ans.add(q.poll().val);
                }
                return ans;
            }

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if(node.left != null && !vis.contains(node.left)){
                    q.offer(node.left);
                    vis.add(node.left);
                }

                if(node.right != null && !vis.contains(node.right)){
                    q.offer(node.right);
                    vis.add(node.right);
                }

                if(parent.get(node) != null && !vis.contains(parent.get(node))){
                    q.offer(parent.get(node));
                    vis.add(parent.get(node));
                }
            }
            dist++;

        }
        return ans;
    }

    private void buildparent(TreeNode node,TreeNode par,Map<TreeNode,TreeNode> parent){
        if(node == null) return;

        parent.put(node,par);
        buildparent(node.left,node,parent);
        buildparent(node.right,node,parent);
    }
}