class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int rotten = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                    rotten++;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;
        if (rotten == 0)
            return -1;
        int time = 0;
        int[] drow = { 0, 1, -1, 0 };
        int[] dcol = { 1, 0, 0, -1 };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nr = drow[i] + r;
                    int nc = dcol[i] + c;

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.offer(new int[] { nr, nc });
                        fresh--;
                    }
                }
            }
            ++time;
        }

        if (fresh > 0)
            return -1;

        return time-1;
    }
}