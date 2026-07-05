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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root,0,ans);
        return ans;
    }

    private void dfs(TreeNode root,int l,List<List<Integer>> ans){
        if(root == null) return;

        if(l == ans.size()){
            ans.add(new ArrayList<>());
        }
        ans.get(l).add(root.val);

        dfs(root.left,l+1,ans);
        dfs(root.right,l+1,ans);
    }
}