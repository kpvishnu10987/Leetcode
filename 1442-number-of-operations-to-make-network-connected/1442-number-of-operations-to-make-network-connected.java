class Solution {
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        int E = connections.length;
        if(E < n-1) return -1;
        for(int i = 0;  i<n ;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis =new int[n];

        int comp = 0;

        for(int i = 0 ;i<n ;i++){
            if(vis[i] == 0){
                dfs(adj,vis,i);
                comp++;
            }
        }
        return comp-1;
        
    }
    private void dfs(List<List<Integer>> adj,int[] vis,int cur){
        vis[cur] = 1;

        for(int i  = 0 ;i<adj.get(cur).size() ; i++){
            int node = adj.get(cur).get(i);
            if(vis[node] == 0){
                dfs(adj,vis,node);
            }
        }
    }
}