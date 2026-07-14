class Solution {
    int[][][] dp;
    int count = 0;
    public int subsequencePairCount(int[] nums) {
        dp = new int[nums.length][201][201];

        for(int[][] row : dp){
            for(int[] r: row){
                Arrays.fill(r,-1);
            }
        }
        return dfs(0,0,0,nums);
    }

    private int dfs(int i,int g1,int g2,int[] nums){
        if(i == nums.length){
            if(g1 != 0 && g2 != 0 && g1 == g2){
                return 1;
            }
            return 0;
        }

        if(dp[i][g1][g2] != -1) return dp[i][g1][g2];

        int x = nums[i];

        int ng1 = (g1 == 0) ? x : gcd(g1,x);
        int ng2 = (g2 == 0) ? x : gcd(g2,x);

        long ans = 0;
        ans += dfs(i+1,ng1,g2,nums);
        ans += dfs(i+1,g1,ng2,nums);
        ans += dfs(i+1,g1,g2,nums);

        

        return dp[i][g1][g2] = (int)(ans % 1000000007);

    }
    
    private int gcd(int a,int b){
        while(b != 0){
            int temp  = b;
            b = a % b;
            a = temp;
        }

        return a;
    }


}