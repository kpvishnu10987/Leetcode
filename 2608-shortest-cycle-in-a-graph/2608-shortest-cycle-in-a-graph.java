class Solution {
    List<List<Integer>> graph;
    boolean[] vis;

    public int findShortestCycle(int n, int[][] edges) {
        vis = new boolean[n];
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int ans = Integer.MAX_VALUE;

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            q.offer(new int[] { i, -1 });
            int dis[] = new int[n];
            Arrays.fill(dis,-1);
            dis[i] = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int[] node = q.poll();
                    int cur = node[0];
                    int par = node[1];

                    for (int nei : graph.get(cur)) {
                        if (dis[nei] == -1) {
                            dis[nei] = dis[cur] + 1;
                            q.offer(new int[] { nei, cur });
                        } else if (nei != par) {
                            ans = Math.min(dis[nei] + dis[cur] + 1, ans);
                        }

                    }
                }
            }
        }

        // int len = Integer.MAX_VALUE;

        // for(int i = 0 ; i<n ; i++){
        //     len = Math.min(len,dfs(i,-1,0));
        // }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
    // private int dfs(int node,int par,int len){
    //     vis[node] = true;

    //     for(int nei : graph.get(node)){
    //         if(vis[nei]){
    //             if(nei != par){
    //                 return len;
    //             }
    //         }else{
    //             len++;
    //             dfs(nei,node,len);
    //             len--;
    //         }
    //     }
    //     return Integer.MAX_VALUE;
    // }
}