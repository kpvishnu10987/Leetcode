class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    vis[i][j] = true;
                    q.offer(new int[] { i, j });
                }
            }
        }
        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                for (int i = 0; i < 4; i++) {
                    int nr = node[0] + drow[i];
                    int nc = node[1] + dcol[i];
                    if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= m - 1 && grid[nr][nc] == 1 && !vis[nr][nc]) {
                        vis[nr][nc]=true;

                        grid[nr][nc] = 1 + grid[r][c];
                        
                        q.offer(new int[] { nr, nc });
                    }
                }
            }
        }
        return grid;
    }
}