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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        f(ans,root,0);
        Collections.reverse(ans);
        return ans;
    }

    private void f(List<List<Integer>> ans,TreeNode root,int level){
        if(root == null) return;

        if(level == ans.size()){
            ans.add(new ArrayList<>());
        }

        ans.get(level).add(root.val);

        f(ans,root.left,level+1);
        f(ans,root.right,level+1);


    }
}