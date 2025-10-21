import java.util.*;

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findPar(int u) {
        if (u == parent.get(u)) return u;
        int root = findPar(parent.get(u));
        parent.set(u, root); 
        return root;
    }

    public void unionBySize(int u, int v) {
        int up_u = findPar(u);
        int up_v = findPar(v);

        if (up_u == up_v) return; 

        if (size.get(up_u) < size.get(up_v)) {
            parent.set(up_u, up_v);
            size.set(up_v, size.get(up_v) + size.get(up_u));
        } else {
            parent.set(up_v, up_u);
            size.set(up_u, size.get(up_u) + size.get(up_v));
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet ds = new DisjointSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) { 
                    ds.unionBySize(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findPar(i) == i) { 
                count++;
            }
        }

        return count;
    }
}
