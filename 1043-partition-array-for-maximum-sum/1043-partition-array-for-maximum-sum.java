class Solution {
    int[] arr;
    int[] memo;
    
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        this.arr = arr;
        this.memo = new int[n];
        Arrays.fill(memo,-1);
        return dp(n-1,k);
    }
    private int dp(int i,int k){
        if(i<0) return 0;
        if(memo[i] != -1) return memo[i];

        int max = 0;
        int curmax = 0;

        for(int len = 1; len <= k && i-len+1 >=0 ; len++){
            curmax = Math.max(curmax,arr[i-len+1]);
            int score = dp(i-len,k)+curmax*len;
            max = Math.max(score,max);
        }

        return memo[i] = max;
    }
}