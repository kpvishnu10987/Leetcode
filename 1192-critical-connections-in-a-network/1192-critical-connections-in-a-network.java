class Solution {
    int[] tin;
    int[] low;
    int[] vis;
    int n;
    int timer =  1;
    List<List<Integer>> ans;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.n = n;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }

        for(List<Integer> c : connections){
            graph.get(c.get(0)).add(c.get(1));
            graph.get(c.get(1)).add(c.get(0));
        }

        ans = new ArrayList<>();
        tin = new int[n];
        low = new int[n];
        vis = new int[n];
        dfs(graph,0,-1);
        return ans;
    }
    private void dfs(List<List<Integer>> graph,int cur,int parent){
        tin[cur] = low[cur] = timer++;
        vis[cur] = 1;

        for(int nei : graph.get(cur)){
            if(nei == parent) continue;

            if(vis[nei] == 0){
                dfs(graph,nei,cur);
                low[cur] = Math.min(low[cur],low[nei]);
                if(tin[cur] < low[nei]){
                    ans.add(Arrays.asList(cur,nei));
                }
            }else{
                low[cur] = Math.min(low[cur],low[nei]);
            }
        }
    }
}