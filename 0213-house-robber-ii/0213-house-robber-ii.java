class Solution {
    int dp1[];
    int dp2[];
    public int rob(int[] nums) {
        int n = nums.length;
        dp1 = new int[n];
        dp2 = new int[n];
        if(n == 1) return nums[0];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];

        for(int i = 0 ;i<n-1 ;i++){
            arr1[i] = nums[i+1];
            arr2[i] = nums[i];
        }

        return Math.max(f(0,arr1,dp1),f(0,arr2,dp2)); 
    }

    private int f(int i,int[] arr,int[] dp){
        if(i >= arr.length) return 0;
        if(dp[i] != -1) return dp[i];

        int t = arr[i] + f(i+2,arr,dp);
        int nt = f(i+1,arr,dp);


        return dp[i] = Math.max(t,nt);
    }
}