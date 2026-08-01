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
    int[] preorder;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        int n = inorder.length;
        for(int i = 0; i<n ; i++){
            map.put(inorder[i],i);
        }
        return build(inorder,0,n-1);
    }

    private TreeNode build(int[] inorder,int i,int j){
        if(i > j) return null;

        int val = preorder[pre++];
        int idx = map.get(val);
        TreeNode node = new TreeNode(val);

        node.left = build(inorder,i,idx-1);
        node.right = build(inorder,idx+1,j);

        return node;
    }
}