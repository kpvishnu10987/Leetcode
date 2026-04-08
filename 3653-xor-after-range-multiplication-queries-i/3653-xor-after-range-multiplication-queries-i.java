class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int MOD = 1000000007;

        long[] mul = new long[n];
        Arrays.fill(mul, 1);  
        for(int i = 0; i < m; i++){
            int[] q = queries[i];
            int idx = q[0];

            while(idx <= q[1]){
                mul[idx] = (mul[idx] * q[3]) % MOD;  
                idx += q[2];
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++){
            nums[i] = (int)((nums[i] * mul[i]) % MOD);  
            res ^= nums[i];
        }

        return res;
    }
}