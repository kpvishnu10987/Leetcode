class Solution {
    public int makeConnected(int n, int[][] connections) {
        int comp = 0;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] con : connections){
            graph.get(con[0]).add(con[1]);
            graph.get(con[1]).add(con[0]);
        }

        boolean vis[] = new boolean[n];
        for(int i = 0 ; i<n ; i++){
            if(!vis[i]){
                comp++;
                dfs(i,vis,graph);
            }
        }

        int need = comp- 1;
        int m = connections.length;
        int remain = m-(n-comp);
        return remain >= need ? need : -1;


    }

    private void dfs(int i,boolean vis[],List<List<Integer>> graph){
        vis[i] = true;

        for(int nei : graph.get(i)){
            if(!vis[nei]){
                dfs(nei,vis,graph);
            }
        }
    }
}