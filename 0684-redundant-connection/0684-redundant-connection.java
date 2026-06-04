class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n+1];

        for(int i = 0 ; i<=n ;i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(find(u) == find(v)){
                return edge;
            }

            union(u,v);
        }

        return new int[0];
    }

    private int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private void union(int u,int v){
        int pu = parent[u];
        int pv = parent[v];

        if(pu != pv){
            parent[pu] = pv;
        }
    }
}