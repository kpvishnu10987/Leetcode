class Solution {
    int[][] dp;
    int[][] events;
    int[] start;
    public int maxValue(int[][] events, int k) {
        this.events = events;
        int n = events.length;

        dp = new int[n][k+1];
        start = new int[n];

        for(int[] r : dp){
            Arrays.fill(r,-1);
        }

        Arrays.sort(events,(a,b)->a[0]-b[0]);
        for(int i = 0 ; i<n ; i++){
            start[i] = events[i][0];
        }

        return f(0,k);
    }

    private int f(int i,int k){
        if(k == 0 || i == events.length){
            return 0;
        }
        if(dp[i][k] != -1) return dp[i][k];

        int nt = f(i+1,k);

        int next = find(events[i][1]);

        int t = events[i][2] + f(next,k-1);

        return dp[i][k] = Math.max(t,nt);
    }

    private int find(int target){
        int l = 0 ;
        int r = start.length;

        while(l < r){
            int mid = l + (r-l)/2;

            if(start[mid] > target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}