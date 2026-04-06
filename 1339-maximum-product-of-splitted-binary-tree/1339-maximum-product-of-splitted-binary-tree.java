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
    long totalSum = 0;
    long maxProduct = 0;
    int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        totalSum = getSum(root);
        solve(root);
        return (int)(maxProduct%MOD);
    }
    private long solve(TreeNode root){
        if(root == null) return 0;

        long left = solve(root.left);
        long right = solve(root.right);

        long sum = left + right+root.val;

        long product = sum * (totalSum -sum);

        maxProduct = Math.max(product,maxProduct);

        return sum;
    }
    private long getSum(TreeNode root){
        if(root == null) return 0;

        return root.val+getSum(root.left)+getSum(root.right);
    }
}