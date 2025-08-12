class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> li = new ArrayList<>();
        for(int i = 0 ; i<cuts.length; i++){
            li.add(cuts[i]);
        }
        li.add(0);
        li.add(n);
        Collections.sort(li);
        int[] arr = new int[li.size()];
        for(int i = 0 ; i<li.size(); i++){
            arr[i] = li.get(i);
        }
        int c = cuts.length;
        int[][] dp = new int[c+1][c+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return helper(1,arr.length-2,arr,dp);
    }
    private int helper(int i ,int j ,int[] arr,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;
        for(int k = i ; k<=j ; k++){
            int cost = arr[j+1]-arr[i-1]+helper(i,k-1,arr,dp)+helper(k+1,j,arr,dp);
            mini = Math.min(mini,cost);
        }
        return dp[i][j] = mini;
    }
}