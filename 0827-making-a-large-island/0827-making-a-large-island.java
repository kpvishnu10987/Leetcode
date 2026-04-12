class Solution {
    int n ;
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DSU dsu = new DSU(n*n);

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                if(grid[i][j] == 1){
                    int r = i;
                    int c = j;
                    for(int[] d : dir){
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if(nr >= 0  && nc >=0  && nr <n && nc < n && grid[nr][nc] == 1){
                            dsu.union(r*n+c,nr*n+nc);
                        }
                    }
                }
            }
        }
        
        int max = 0;

        for(int i = 0 ;i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                if(grid[i][j] == 0){
                    Set<Integer> set = new HashSet<>();

                    for(int[] d : dir){
                        int nr = i+d[0];
                        int nc = j+d[1];
                        if(nr >= 0  && nc >=0  && nr <n && nc < n && grid[nr][nc] == 1){
                            set.add(dsu.find(nr*n+nc));
                        }
                    }
                    int size = 1;
                    for(int parent : set){
                        size += dsu.size[parent];
                    }

                    max = Math.max(max,size);
                }
            }
        }
        for (int i = 0; i < n*n; i++) {
            if (dsu.find(i) == i) {
                max = Math.max(max, dsu.size[i]);
            }
        }

        return max;
    }

    class DSU{
        int[] parent;
        int[] size;

        DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0 ; i<n ; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x){
            if(parent[x] == x) return parent[x];
            return parent[x] = find(parent[x]);
        }

        void union(int u,int v){
            int pu = find(u);
            int pv = find(v);

            if(pu == pv) return;

            if(size[pu] > size[pv]){
                parent[pv] = pu;
                size[pu] += size[pv];
            }else{
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }
    }
}