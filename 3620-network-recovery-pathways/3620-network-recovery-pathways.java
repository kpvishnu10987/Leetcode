import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        int[] indegree = new int[n];
        int maxEdge = 0;

        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxEdge = Math.max(maxEdge, e[2]);
        }

        // Topological Order
        List<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);

            for (int[] e : graph.get(u)) {
                if (--indegree[e[0]] == 0)
                    q.offer(e[0]);
            }
        }

        int low = 0;
        int high = maxEdge;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(mid, graph, topo, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int minEdge,
                          List<List<int[]>> graph,
                          List<Integer> topo,
                          boolean[] online,
                          long k,
                          int n) {

        long INF = Long.MAX_VALUE / 4;

        long[] dp = new long[n];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int u : topo) {

            if (dp[u] == INF)
                continue;

            // Intermediate offline nodes cannot be used
            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (int[] edge : graph.get(u)) {

                int v = edge[0];
                int w = edge[1];

                if (w < minEdge)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                dp[v] = Math.min(dp[v], dp[u] + w);
            }
        }

        return dp[n - 1] <= k;
    }
}