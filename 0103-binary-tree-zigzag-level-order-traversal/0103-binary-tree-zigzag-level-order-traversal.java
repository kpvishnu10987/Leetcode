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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans,root,0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans,TreeNode root, int l){
        if(root == null) return;
        if(l == ans.size()){
            ans.add(new ArrayList<>());
        }

        if(l % 2 == 0){
            ans.get(l).add(root.val);
        }else{
            ans.get(l).addFirst(root.val);
        }

        dfs(ans,root.left,l+1);
        dfs(ans,root.right,l+1);
    }
}