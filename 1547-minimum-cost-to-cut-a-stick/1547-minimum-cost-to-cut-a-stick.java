class Solution {
    int n;
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        this.n = n;
        int[] nums = new int[cuts.length+2];
        
        nums[0] = 0;
        nums[nums.length-1] = n;
        for(int i = 0 ; i<cuts.length; i++){
            nums[i+1] = cuts[i];
        }
        dp = new int[nums.length][nums.length];
        for(int[] r: dp){
            Arrays.fill(r,-1);
        }

        return f(nums,1,cuts.length);
    }

    private int f(int[] nums,int i,int j){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int cost = 0;
        int min = Integer.MAX_VALUE;

        

        for(int k = i; k<=j ; k++){
            
            cost = nums[j+1]-nums[i-1]+ f(nums,i,k-1) + f(nums,k+1,j);
            min = Math.min(cost,min);
        }

        return dp[i][j] = min;
    }
}