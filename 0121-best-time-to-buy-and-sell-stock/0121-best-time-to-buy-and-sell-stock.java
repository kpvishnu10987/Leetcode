class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int pro = 0;

        for(int i = 0 ; i<n ;i++){
            min = Math.min(prices[i],min);
            pro = Math.max(pro,prices[i] - min);
        }
        return pro;
    }
}