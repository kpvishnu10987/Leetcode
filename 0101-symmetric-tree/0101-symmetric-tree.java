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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while(!q.isEmpty()){
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();

            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null) return false;
            if(n1.val != n2.val) return false;

            q.offer(n1.left);
            q.offer(n2.right);

            q.offer(n1.right);
            q.offer(n2.left);
        }
        return true;
    }
}