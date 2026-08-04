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
    int count = 0;
    public int goodNodes(TreeNode root) {
        f(root,Integer.MIN_VALUE);
        return count;
    }

    private void f(TreeNode root,int max){
        if(root == null) return;

        if(root.val >= max){
            count++;
            max = root.val;
        }

        f(root.left,max);
        f(root.right,max);
    }
}