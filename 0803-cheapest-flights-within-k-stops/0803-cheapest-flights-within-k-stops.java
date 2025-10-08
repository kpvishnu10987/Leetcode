

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], k -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0}); // {city, cost, stops}

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int city = cur[0], cost = cur[1], stops = cur[2];

            if (stops > K) continue;

            if (!graph.containsKey(city)) continue;
            for (int[] next : graph.get(city)) {
                int nextCity = next[0];
                int nextCost = cost + next[1];

                if (nextCost < dist[nextCity]) {
                    dist[nextCity] = nextCost;
                    q.offer(new int[]{nextCity, nextCost, stops + 1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
