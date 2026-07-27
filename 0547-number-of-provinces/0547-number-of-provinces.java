class Solution {
    int[] par;
    int[] size;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        par = new int[n];
        size = new int[n];

        for(int i = 0 ; i<n ; i++){
            par[i] = i;
            size[i] = 1;
        }

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(isConnected[i][j] == 1){
                    if(find(i) == find(j)) continue;
                    union(i,j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i<n ; i++){
            set.add(find(i));
        }

        return set.size();

    }

    private int find(int x){
        if(par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    private void union(int u,int v){
        int pu = find(u);
        int pv = find(v);

        if(size[pu] > size[pv]){
            par[pv] = pu;
            size[pu] += size[pv];
        }else{
            par[pu] = pv;
            size[pv] += size[pu];
        }
    }
}