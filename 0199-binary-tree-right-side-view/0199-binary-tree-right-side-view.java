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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        df(root,0,ans);
        return ans;
    }
    private void df(TreeNode node,int level,List<Integer> ans){
        if(node == null) return;

        if(ans.size()==level){
            ans.add(node.val);
        }
        df(node.right,level+1,ans);
        df(node.left,level+1,ans);
    }
}