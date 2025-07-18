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
    TreeNode newnode;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        newnode = new TreeNode(val);
        if(root == null) return newnode;
        insert(root,val,newnode);
        return root;
    }
    private void insert(TreeNode node,int val,TreeNode newnode){
        // if(node == null) return node;

        while(node != null && node != newnode){
            if(node.val > val ){
                if(node.left == null){
                    node.left = newnode;
                }else{
                    node = node.left;
                } 
            }else{
                if(node.right != null){
                    node = node.right;
                }else{
                    node.right = newnode;
                }
            }
        }
    }
}