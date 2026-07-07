class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        // -1 means unreachable
        for (int i = 0; i < n; i++) {
            Arrays.fill(score[i], -1);
        }

        score[0][0] = 0;
        ways[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                char ch = board.get(i).charAt(j);

                if (ch == 'X') continue;
                if (i == 0 && j == 0) continue;

                int best = -1;
                long cnt = 0;

                // From Top
                if (i > 0 && score[i - 1][j] != -1) {
                    if (score[i - 1][j] > best) {
                        best = score[i - 1][j];
                        cnt = ways[i - 1][j];
                    } else if (score[i - 1][j] == best) {
                        cnt = (cnt + ways[i - 1][j]) % MOD;
                    }
                }

                // From Left
                if (j > 0 && score[i][j - 1] != -1) {
                    if (score[i][j - 1] > best) {
                        best = score[i][j - 1];
                        cnt = ways[i][j - 1];
                    } else if (score[i][j - 1] == best) {
                        cnt = (cnt + ways[i][j - 1]) % MOD;
                    }
                }

                // From Diagonal
                if (i > 0 && j > 0 && score[i - 1][j - 1] != -1) {
                    if (score[i - 1][j - 1] > best) {
                        best = score[i - 1][j - 1];
                        cnt = ways[i - 1][j - 1];
                    } else if (score[i - 1][j - 1] == best) {
                        cnt = (cnt + ways[i - 1][j - 1]) % MOD;
                    }
                }

                if (best == -1) continue;

                score[i][j] = best;
                ways[i][j] = (int) (cnt % MOD);

                if (ch >= '1' && ch <= '9') {
                    score[i][j] += ch - '0';
                }
            }
        }

        if (ways[n - 1][n - 1] == 0) {
            return new int[]{0, 0};
        }

        return new int[]{score[n - 1][n - 1], ways[n - 1][n - 1]};
    }
}