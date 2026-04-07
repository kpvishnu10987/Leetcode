class Solution {
    List<List<Integer>> graph;
    int[] count;  // number of nodes in subtree
    int[] res;    // answer array
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        
        graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        // Build graph
        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        count = new int[n];
        res = new int[n];

        // Step 1: Postorder DFS
        dfs1(0, -1);

        // Step 2: Preorder DFS
        dfs2(0, -1);

        return res;
    }

    // Postorder DFS (Bottom-Up)
    private void dfs1(int node, int parent) {
        count[node] = 1; // count itself
        
        for(int child : graph.get(node)) {
            if(child == parent) continue;

            dfs1(child, node);

            count[node] += count[child];
            res[node] += res[child] + count[child];
        }
    }

    // Preorder DFS (Top-Down Re-rooting)
    private void dfs2(int node, int parent) {
        for(int child : graph.get(node)) {
            if(child == parent) continue;

            // Re-root formula
            res[child] = res[node] - count[child] + (n - count[child]);

            dfs2(child, node);
        }
    }
}