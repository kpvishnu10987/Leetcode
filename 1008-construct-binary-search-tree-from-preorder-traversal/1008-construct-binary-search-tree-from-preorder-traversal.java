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
    int preidx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder,int bound){
        if(preidx == preorder.length) return null;

        if(preorder[preidx] > bound) return null;

        TreeNode cur = new TreeNode(preorder[preidx++]);

        cur.left = build(preorder,cur.val);

        cur.right = build(preorder,bound);

        return cur;
    }
}