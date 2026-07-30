class Solution {
    int[] dp;
    int[] days;
    int[] costs;
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        int n = days.length;
        dp = new int[n];
        Arrays.fill(dp,-1);

        return f(0);
    }
    private int f(int i){
        if(i == days.length) return 0;

        if(dp[i] != -1) return dp[i];

        int one = costs[0] + f(i+1);
        int nextweek = find(days[i] + 6);
        int nextmon = find(days[i] + 29);
        int seven = costs[1] + f(nextweek);
        int month = costs[2] + f(nextmon);

        return dp[i] = Math.min(one,Math.min(seven,month));
    }
    private int find(int target){
        int l = 0;
        int r = days.length;

        while(l < r){
            int mid = l + (r-l)/2;

            if(days[mid] > target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}