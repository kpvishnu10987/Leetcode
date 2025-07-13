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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        int l = 1;

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        while(!qu.isEmpty()){
            int size = qu.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0; i<size ; i++){
                TreeNode temp = qu.poll();
                level.add(temp.val);
                if(temp.left != null) qu.offer(temp.left);
                if(temp.right != null) qu.offer(temp.right);
            }
            l++;
            if(l % 2 == 1) {
                Collections.reverse(level);
            }
            result.add(level);
        }
        return result;
    }
}