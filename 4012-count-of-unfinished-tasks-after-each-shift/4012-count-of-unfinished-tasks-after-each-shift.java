class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;
        long[] pre = new long[n+1];
        pre[0] = 0;
        long total = 0;

        for(int i = 1 ; i<=n ; i++){
            pre[i] = pre[i-1] + tasks[i-1];
            total += tasks[i-1];
        }

        long completed = 0;
        int[] ans = new int[m];
        
        for(int i = 0 ; i<m ;i++){
            completed += shifts[i];

            if(completed >= total){
                ans[i] = 0;
                completed = 0;
            }else{
                int idx = upper(pre,completed);
                ans[i] = n-idx+1;
            }
        }

        return ans;
    }
    private int upper(long[] pre,long completed){
        int l = 0;
        int r = pre.length-1;

        while(l < r){
            int mid = l + (r-l)/2;
           
            if(pre[mid] > completed){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return l;
    }
}