class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int off = 20000;

        DSU dsu = new DSU(2*off);

        Set<Integer> set = new HashSet<>();

        for(int[] stone : stones){
            int row = stone[0];
            int col = stone[1]+off;

            dsu.union(row,col);

            set.add(row);
            set.add(col);
        }

        int comp = 0;
        for(int stone : set){
            if(dsu.find(stone) == stone) comp++;
        }

        return n-comp;
    }

    class DSU{
        int[] parent;

        DSU(int n){
            parent = new int[n];
            for(int i = 0 ; i<n ; i++){
                parent[i] = i;
            }
        }

        int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        void union(int u,int v){
            int pu = find(u);
            int pv = find(v);
            if(pu != pv) parent[pu] = pv;
        }
    }
}