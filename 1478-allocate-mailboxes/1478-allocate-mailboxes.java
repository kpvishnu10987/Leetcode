class Solution {

    int[][] cost;
    Integer[][] memo;
    int[] houses;
    int n;

    public int minDistance(int[] houses, int k) {

        Arrays.sort(houses);

        this.houses = houses;
        n = houses.length;

        cost = new int[n][n];

        // Precompute interval costs
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int mid = (i + j) / 2;

                for (int x = i; x <= j; x++) {
                    cost[i][j] += Math.abs(houses[x] - houses[mid]);
                }
            }
        }

        memo = new Integer[n][k + 1];

        return dfs(0, k);
    }

    private int dfs(int idx, int k) {

        if (idx == n)
            return k == 0 ? 0 : 1000000000;

        if (k == 0)
            return 1000000000;

        if (memo[idx][k] != null)
            return memo[idx][k];

        int ans = Integer.MAX_VALUE;

        for (int j = idx; j < n; j++) {
            ans = Math.min(ans,
                    cost[idx][j] + dfs(j + 1, k - 1));
        }

        return memo[idx][k] = ans;
    }
}