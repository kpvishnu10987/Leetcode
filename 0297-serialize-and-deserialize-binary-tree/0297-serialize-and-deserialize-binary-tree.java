/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index = 0;

    // Encodes a tree to a single string.
    StringBuilder sb = new StringBuilder();
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    private void dfs(TreeNode root){
        if(root == null){
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");

        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[] = data.split(",");
        index = 0;
        return build(arr);
    }

    private TreeNode build(String[] arr){
        if(arr[index].equals("N")){
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));

        root.left = build(arr);
        root.right = build(arr);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));