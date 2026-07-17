class Solution {
    boolean[] vis;
    List<List<Integer>> graph;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        graph = rooms;
        vis = new boolean[graph.size()];
        dfs(0);

        for(int i = 0 ; i<graph.size(); i++){
            if(!vis[i]) return false;
        }
        return true;
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