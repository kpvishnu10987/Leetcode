class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < cuts.length; i++) {
            li.add(cuts[i]);
        }
        li.add(0);
        li.add(n);
        Collections.sort(li);
        int[] arr = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            arr[i] = li.get(i);
        }
        int c = cuts.length;
        int[][] dp = new int[c + 2][c + 2];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) {
                    continue;
                }

                int mini = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = arr[j + 1] - arr[i - 1] + dp[i][k - 1] + dp[k + 1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;

            }
        }
        return dp[1][c];
    }

}