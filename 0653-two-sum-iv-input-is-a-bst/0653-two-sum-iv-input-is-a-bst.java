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
    public boolean findTarget(TreeNode root, int k) {
       return dfs(root,root,k);
    }
    private boolean dfs(TreeNode root,TreeNode current,int k){
        if(current == null) return false;

        if(find(root,current,k-current.val)) return true;

        return dfs(root,current.left,k) || dfs(root,current.right,k);
    }
    private boolean find(TreeNode root,TreeNode exclude,int k){
        if(root == null) return false;
        if(root.val == k && root != exclude) return true;
        if(root.val > k){
            return find(root.left,exclude,k);
        }else{
            return find(root.right,exclude,k);
        }
    }
}