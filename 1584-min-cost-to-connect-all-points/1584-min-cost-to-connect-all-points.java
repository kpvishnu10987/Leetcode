class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];


        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0});
        int ans = 0;
        int count = 0;

        while(count < n){
            int node[] = pq.poll();
            int cost = node[0];
            int idx = node[1];
            if(vis[idx]) continue;

            vis[idx] = true;
            count++;
            ans += cost;

            for(int i = 0 ; i<n ; i++){
                if(!vis[i]){
                    int mincost = Math.abs(points[idx][0]-points[i][0]) + Math.abs(points[idx][1]-points[i][1]);

                    pq.offer(new int[]{mincost,i});
                }
            }
        }

        return ans;
    }
}