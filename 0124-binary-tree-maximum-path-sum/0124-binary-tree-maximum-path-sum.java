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
    int maxs = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxsum(root);
        return maxs;
    }

    private int maxsum(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, maxsum(node.left));
        int right = Math.max(0, maxsum(node.right));

        maxs = Math.max(maxs, node.val + left + right);

        return node.val + Math.max(left, right);
    }
}
