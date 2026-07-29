class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;

        dp = new int[arr.length][arr.length];

        for(int[] r : dp){
            Arrays.fill(r,-1);
        }

        for(int i = 0 ; i<n ;i++){
            arr[i+1] = nums[i];
        }

        return f(arr,1,n);


    }
    private int f(int[] arr,int i,int j){
        if(i >j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int cost = 0;
        int max = Integer.MIN_VALUE;

        for(int k = i ; k<=j ; k++){
            cost = arr[i-1] * arr[k] * arr[j+1] + f(arr,i,k-1) + f(arr,k+1,j);
            max = Math.max(max,cost);
        } 

        return dp[i][j] =max;
    }
}