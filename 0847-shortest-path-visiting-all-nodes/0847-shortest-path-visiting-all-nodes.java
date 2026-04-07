class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] v = new boolean[n][1<<n];

        for(int i  = 0 ; i<n ; i++){
            int mask = 1<<i;
            q.offer(new int[]{i,mask});
            v[i][mask] = true;
        }

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i<size ; i++){
                int[] cur = q.poll();
                int node = cur[0];
                int mask = cur[1];

                if(mask == (1<<n)-1) return steps;

                for(int nei : graph[node]){
                    int newmask = mask|(1<<nei);

                    if(!v[nei][newmask]){
                        v[nei][newmask] = true;
                        q.offer(new int[]{nei,newmask});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

}