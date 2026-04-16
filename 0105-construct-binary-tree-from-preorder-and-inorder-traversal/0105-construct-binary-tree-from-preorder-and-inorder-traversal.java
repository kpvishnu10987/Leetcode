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
    int preIndex = 0;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for(int i = 0 ; i<n ; i++){
            map.put(inorder[i],i);
        }

        return build(preorder,0,n-1);
    }
    private TreeNode build(int[] preorder,int inStart,int inEnd){
        if(inStart > inEnd) return null;

        int rootval = preorder[preIndex++];
        TreeNode root = new TreeNode(rootval);

        int inIndex = map.get(rootval);

        root.left = build(preorder,inStart,inIndex-1);
        root.right = build(preorder,inIndex+1,inEnd);
        return root;
    }
}