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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        boolean lr = true;

        while(!qu.isEmpty()){
            int size = qu.size();
            Deque<Integer> level = new LinkedList<>();

            for(int i = 0 ; i<size;i++){
                TreeNode temp = qu.poll();
                if(lr){
                    level.offerLast(temp.val);
                }else{
                    level.offerFirst(temp.val);
                }

                if(temp.left != null) qu.offer(temp.left);
                if(temp.right != null) qu.offer(temp.right);
            }

            result.add(new ArrayList<>(level));
            lr = !lr;
        }
        return result;
        
    }
}