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
    Map<String,Integer> map = new HashMap<>();;
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return ans;
    }
    private String serialize(TreeNode root){
        if(root == null) return "#";

        String left = serialize(root.left);
        String right = serialize(root.right);

        String total = root.val + "," + left + "," + right;
        map.put(total,map.getOrDefault(total,0)+1);
        if(map.get(total) == 2) ans.add(root);

        return total;
    }
}