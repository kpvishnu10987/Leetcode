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
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return dia;
    }

    private int f(TreeNode root){
        if(root == null) return 0;

        int left = f(root.left);
        int right = f(root.right);

        dia = Math.max(dia,left+right);

        return 1+Math.max(left,right);
    }
}