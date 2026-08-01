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
    int k;
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        f(root);
        return ans;
    }
    private void f(TreeNode root){
        if(root == null) return;
        if(ans != -1) return;

        f(root.left);
        k--;
        if(k == 0) ans = root.val;
        f(root.right);
    }
}