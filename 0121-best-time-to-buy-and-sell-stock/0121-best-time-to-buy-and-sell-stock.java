class Solution {
    public int maxProfit(int[] prices) {
        int big = 0;
        int small = prices[0];
        for(int i = 1 ; i<prices.length ; i++){
            if(prices[i] < small){
                small = prices[i];
                continue;
            }
            int profit = prices[i] - small;
            big = Math.max(big,profit);
        }

        return big;
        
    }
}