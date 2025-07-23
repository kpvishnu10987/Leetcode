class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(i != n-1){
                arr1.add(nums[i]);
            }
            if(i != 0){
                arr2.add(nums[i]);
            }
        }
        int[] arr11 = arr1.stream().mapToInt(i -> i).toArray();
        int[] arr22 = arr2.stream().mapToInt(i -> i).toArray();
        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n-1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int last = f(arr22,dp2,n-2);
        int first = f(arr11,dp1,n-2);
        
        return Math.max(last,first);
        
    }
    private int f(int[] nums,int[] dp,int ind){
        if(ind == 0) return nums[ind];
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind]+f(nums,dp,ind-2);
        int notpick = f(nums,dp,ind-1);
        dp[ind] = Math.max(pick,notpick);
        return dp[ind];
    }
}