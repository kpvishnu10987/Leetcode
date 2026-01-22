import java.util.*;

class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();

        // Pacific Ocean (top row & left column)
        for (int i = 0; i < m; i++) {
            pacific[0][i] = true;
            pq.offer(new int[]{0, i});
        }
        for (int i = 0; i < n; i++) {
            pacific[i][0] = true;
            pq.offer(new int[]{i, 0});
        }

        // Atlantic Ocean (bottom row & right column)
        for (int i = 0; i < m; i++) {
            atlantic[n - 1][i] = true;
            aq.offer(new int[]{n - 1, i});
        }
        for (int i = 0; i < n; i++) {
            atlantic[i][m - 1] = true;
            aq.offer(new int[]{i, m - 1});
        }

        bfs(pq, pacific, heights);
        bfs(aq, atlantic, heights);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m
                        && !ocean[nr][nc]
                        && heights[nr][nc] >= heights[r][c]) {

                    ocean[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
