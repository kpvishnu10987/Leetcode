class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] comp = new int[n];
        int com = 0;
        comp[0] = 0;
        for(int i = 1 ; i<n ; i++){
            if(nums[i]-nums[i-1] > maxDiff){
                com++;
            }

            comp[i] = com;
        }

        boolean[] ans = new boolean[queries.length];

        for(int i = 0 ; i< queries.length ; i++){
            int[] q = queries[i];
            int src = q[0];
            int dest = q[1];

            if(src == dest || comp[src] == comp[dest]){
                ans[i] = true;
            }
        }

        return ans;

        
    }
}