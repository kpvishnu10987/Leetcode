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
    int pre = 0;
    Map<Integer,Integer> map = new HashMap<>();
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int n = inorder.length;
        for(int i = 0 ; i<n ; i++){
            map.put(inorder[i],i);
        }

        return build(inorder,0,n-1);
    }

    private TreeNode build(int[] inorder,int l,int r){
        if(r < l) return null;

        if(pre >= preorder.length) return null;

        int val = preorder[pre++];

        TreeNode root = new TreeNode(val);
        int idx = map.get(val);
        root.left = build(inorder,l,idx-1);
        root.right = build(inorder,idx+1,r);

        return root;
    }
}