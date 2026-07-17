class Solution {
    List<List<Integer>> graph;
    boolean vis[];
    public int findCircleNum(int[][] isConnected) {
        graph = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                if(isConnected[i][j] == 1){
                    graph.get(i).add(j);
                }
            }
        }

        vis = new boolean[n];
        int comp = 0;



        for(int i = 0 ; i<n ;i++){
            if(!vis[i]){
                comp++;
                dfs(i);
            }
        }

        return comp;
    }

    private void dfs(int i){
        vis[i] = true;

        for(int nei : graph.get(i)){
            if(!vis[nei]){
                dfs(nei);

            }
        }
    }
}