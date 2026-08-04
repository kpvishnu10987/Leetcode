class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int[] drow = {0,1,0,-1};
        int[] dcol ={1,0,-1,0};
        int comp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    vis[i][j] = true;
                    comp++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] { i, j });

                    while (!q.isEmpty()) {
                        int size = q.size();
                        for(int k = 0 ; k<size; k++){

                        

                        int[] cur = q.poll();
                        int r = cur[0];
                        int c = cur[1];

                        for (int a = 0; a < 4; a++) {
                            int nr = r + drow[a];
                            int nc = c + dcol[a];

                            if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1' && !vis[nr][nc]) {
                                vis[nr][nc] = true;
                                q.offer(new int[] { nr, nc });
                            }
                        }
                        }
                    }
                }
            }
        }

        return comp;

    }
}