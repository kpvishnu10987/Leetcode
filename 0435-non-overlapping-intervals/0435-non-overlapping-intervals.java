class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] != b[0]){
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        });

        int[] prev = intervals[0];
        int n = intervals.length;
        int c = 0;

        for(int i= 1 ; i<n; i++){
            if(prev[1] <= intervals[i][0]){
                prev = intervals[i];
            }else{
                c++;
                prev[0] = Math.min(prev[0],intervals[i][0]);
                prev[1] = Math.min(prev[1],intervals[i][1]);
            }
        }
        return c;
    }
}