
class Pair {
    int node;
    int time;
    Pair(int n, int t) {
        node = n;
        time = t;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] edge : times) {
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];
            adj.get(src).add(new Pair(dest, wt));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int time = curr.time;

            for (Pair nei : adj.get(u)) {
                int v = nei.node;
                int wt = nei.time;
                if (time + wt < dist[v]) {
                    dist[v] = time + wt;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
