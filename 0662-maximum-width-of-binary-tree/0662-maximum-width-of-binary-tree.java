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
    class Pair{
        TreeNode root;
        long idx;
        Pair(TreeNode root,long idx){
            this.root = root;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        long max = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int size = q.size();
            long start = -1;
            long end = -1;
            for(int i = 0 ; i<size ; i++){
                Pair cur = q.poll();
                TreeNode node = cur.root;
                long curidx = cur.idx;
                if(i == 0){
                    start = curidx;
                }
                if(i == size-1){
                    end = curidx;
                }
                long next = 2*curidx;

                if(node.left != null) q.offer(new Pair(node.left,next+1));
                if(node.right != null) q.offer(new Pair(node.right,next+2));
            }
            max = Math.max(max,end-start);
        }

        return (int)max+1;
    }
}