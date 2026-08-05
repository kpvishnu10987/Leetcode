class Solution {
    int[] par;
    int[] size;
    public int[] findRedundantConnection(int[][] edges) {
        int n  = edges.length;
        par = new int[n+1];
        size = new int[n+1];

        for(int i = 0 ; i<n ; i++){
            par[i] = i;
            size[i] = 1;
        }

        for(int[] e : edges){
            if(find(e[0]) == find(e[1])) return e;

            union(e[0],e[1]);
        }

        return new int[0];
    }

    private int find(int x){
        if(x == par[x]) return x;
        
        return par[x] = find(par[x]);
    }

    private void union(int u,int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return;

        if(size[pu] > size[pv]){
            par[pv] = pu;
            size[pu] += size[pv];
        }else{
            par[pu] = pv;
            size[pv] += size[pu];
        }
    }
}