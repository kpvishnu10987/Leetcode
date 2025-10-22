class Solution {
    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] tin = new int[n];
        int[] low = new int[n];
        int[] vis = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(adj, tin, low, vis, 0, -1, bridges);
            }
        }

        return bridges;
    }

    private void dfs(List<List<Integer>> adj, int[] tin, int[] low, int[] vis,
                     int cur, int par, List<List<Integer>> bridges) {

        vis[cur] = 1;
        tin[cur] = low[cur] = timer++;

        for (int it : adj.get(cur)) {
            if (it == par) continue;

            if (vis[it] == 0) {
                dfs(adj, tin, low, vis, it, cur, bridges);
                low[cur] = Math.min(low[cur], low[it]);

                
                if (low[it] > tin[cur]) {
                    bridges.add(Arrays.asList(cur, it));
                }
            } else {
                low[cur] = Math.min(low[cur], tin[it]);
            }
        }
    }
}
