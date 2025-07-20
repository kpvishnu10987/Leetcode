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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1;i<n;i++){
            insert(root,preorder[i]);
        }
        return root;
    }
    private TreeNode insert(TreeNode node,int value){
        if(node== null){
            return new TreeNode(value);
        }
        if(node.val > value){
            node.left=insert(node.left,value);
        }else if(node.val < value){
            node.right = insert(node.right,value);
        }
        return node;
    }

    
}