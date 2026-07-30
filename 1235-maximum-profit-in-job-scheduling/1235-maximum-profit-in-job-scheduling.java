class Solution {
    int[] dp;
    int[] starts;
    public int jobScheduling(int[] start, int[] end, int[] profit) {
       int n = start.length;
       dp = new int[n];
       Arrays.fill(dp,-1);
       starts = new int[n];
       

       List<int[]> jobs = new ArrayList<>();

       for(int i = 0 ; i<n ; i++){
            jobs.add(new int[]{start[i],end[i],profit[i]});
       } 
       jobs.sort((a,b)->(a[0]-b[0]));
       for(int i = 0 ; i<n ;i++){
        starts[i] = jobs.get(i)[0];
       }

       return f(0,jobs);
    }

    private int f(int i,List<int[]> jobs){
        if(i == jobs.size()){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        

        int nt = f(i+1,jobs);
        int next = find(jobs.get(i)[1]);

        int take = jobs.get(i)[2] + f(next,jobs);

        return dp[i] = Math.max(take,nt);
    }

    private int find(int target){
        int l = 0;
        int r = starts.length;

        while(l < r){
            int mid = l + (r-l)/2;
            if(starts[mid] >= target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}