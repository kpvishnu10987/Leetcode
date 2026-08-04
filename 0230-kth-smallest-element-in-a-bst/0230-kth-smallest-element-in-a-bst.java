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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        Stack<TreeNode> st = new Stack<>();
        int count = 0;

        while(true){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            

            root = st.pop();
            count++;

            if(count == k) return root.val;

            root = root.right;
        }

    }
}