class Solution {
    int[] parent;
    int[] nodec;
    int[] edgec;
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        nodec = new int[n];
        edgec = new int[n];

        for(int i = 0 ; i<n ; i++){
            parent[i] = i;
            nodec[i] = 1;
        }

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];

            int pu = find(u);
            int pv = find(v);

            if(pu != pv){
                parent[pu] = pv;

                nodec[pv] += nodec[pu];
                edgec[pv] += edgec[pu]+1;
            }else{
                edgec[pv]++;
            }
        }

        int comp = 0;

        for(int i = 0 ; i<n ;i++){
            if(parent[i] == i){
                int node = nodec[i];
                int edge = edgec[i];
                int m = (node * (node-1))/2;
                if(edge == m) comp++;
            }
        }

        return comp;
    }

    private int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
}