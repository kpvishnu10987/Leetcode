import java.util.*;

class Edge {
    int node;
    long wt;  // use long to handle large edge weights

    public Edge(int d, long w) {
        this.node = d;
        this.wt = w;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        // --- Step 1: Build adjacency list ---
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            long w = edge[2];
            adj.get(u).add(new Edge(v, w));
            adj.get(v).add(new Edge(u, w)); // bi-directional
        }

        // --- Step 2: Initialize distance and ways arrays ---
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        // --- Step 3: Dijkstra’s algorithm ---
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> Long.compare(x.wt, y.wt));
        pq.offer(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int u = cur.node;
            long w = cur.wt;

            // skip outdated entries
            if (w > dist[u]) continue;

            for (Edge e : adj.get(u)) {
                int dest = e.node;
                long dis = e.wt;

                if (w + dis < dist[dest]) {
                    dist[dest] = w + dis;
                    pq.offer(new Edge(dest, dist[dest]));
                    ways[dest] = ways[u];
                } else if (w + dis == dist[dest]) {
                    ways[dest] = (ways[dest] + ways[u]) % MOD;
                }
            }
        }

        // --- Step 4: Return the number of shortest paths to destination ---
        return (int) (ways[n - 1] % MOD);
    }
}
