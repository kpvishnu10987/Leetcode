class Solution {
    public int maxProfit(int[] nums) {
        int n  = nums.length;
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i<n ; i++){
            min = Math.min(min,nums[i]);
            profit = Math.max(profit,nums[i]-min);
        }
        return profit;
    }
}