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
        TreeNode node;
        long index;
        Pair(TreeNode node,long index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        long maxwidth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            long base = q.peek().index;
            long first =0,last = 0;
            for(int i = 0 ; i<size ; i++){
                Pair cur = q.poll();
                long curidx = cur.index;
                if(i == 0) first = curidx-base;
                if(i == size-1) last = curidx-base;

                if(cur.node.left != null) q.offer(new Pair(cur.node.left,2*cur.index));
                if(cur.node.right != null) q.offer(new Pair(cur.node.right,2*cur.index+1));
            }
            maxwidth = Math.max(maxwidth,last-first);

        }
        return (int)maxwidth+1;
        
    }
}