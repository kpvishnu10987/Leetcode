class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
            matrix[i][i] = 0;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            matrix[u][v] = wt;
            matrix[v][u] = wt;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        int node = -1;
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                node = i;
            }

        }
        return node;

    }
}