class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cheaper = Integer.MAX_VALUE;
        int profit = 0;
        int maxi = 0;


        for(int i = 0 ; i<n ; i++){
            cheaper = (cheaper>prices[i])?prices[i]:cheaper;
            profit = prices[i]-cheaper;
            if(profit > maxi){
                maxi = profit;
            }
        }
        return maxi;
    }
}