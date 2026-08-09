class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[n - 1][m - 1] == 1 || grid[0][0] == 1)
            return -1;

        boolean[][] vis = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });
        vis[0][0] = true;
        int len = 1;
        int drow[] = { 1, 1, 0, -1, 0, -1, 1, -1 };
        int dcol[] = { 1, 0, 1, 0, -1, -1, -1, 1 };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                if (r == n - 1 && c == m - 1)
                    return len;
                for (int i = 0; i < 8; i++) {
                    int nr = r + drow[i];
                    int nc = c + dcol[i];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 0) {
                        vis[nr][nc] = true;
                        q.offer(new int[] { nr, nc });
                    }
                }
            }

            len++;
        }

        return -1;
    }
}