class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int vis[] = new int[n];
        int comp = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(adj, vis, i);
                comp++;
            }
        }
        return n - comp;
    }

    private void dfs(List<List<Integer>> adj, int[] vis, int cur) {
        vis[cur] = 1;
        for (int i = 0; i < adj.get(cur).size(); i++) {
            int node = adj.get(cur).get(i);
            if (vis[node] == 0) {
                dfs(adj, vis, node);
            }
        }
    }
}