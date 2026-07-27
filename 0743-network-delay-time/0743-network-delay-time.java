class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> graph = new ArrayList<>(n+1);

        for(int i = 0 ; i<=n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int e[] : times){
            graph.get(e[0]).add(new int[]{e[2],e[1]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        dist[k] = 0;
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[1];
            int d = node[0];
            if(dist[u] < d) continue;

            for(int[] nei : graph.get(u)){
                int v = nei[1];
                int wt = nei[0];
                if(d + wt < dist[v]){
                    dist[v] = d+wt;
                    pq.offer(new int[]{dist[v],v});
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 1 ; i<=n ; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,dist[i]);
        }

        return ans;

    }
}