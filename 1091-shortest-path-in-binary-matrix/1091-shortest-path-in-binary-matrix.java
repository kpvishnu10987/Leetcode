class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1 || grid[n-1][m-1] ==1) return -1;


        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        int path = 0;
        int[] drow = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dcol = { -1, 0, 1, -1, 1, -1, 0, 1 };

        while (!q.isEmpty()) {
            int size = q.size();
            path++;

            for (int k = 0; k < size; k++) {
                int[] node = q.poll();
                if (node[0] == n - 1 && node[1] == m - 1)
                    return path;
                for (int i = 0; i < 8; i++) {
                    int nr = node[0] + drow[i];
                    int nc = node[1] + dcol[i];
                    if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= m - 1 && grid[nr][nc] == 0) {
                        grid[nr][nc] = 1;
                        q.offer(new int[] { nr, nc });
                    }
                }
            }
        }
        return -1;
    }
}