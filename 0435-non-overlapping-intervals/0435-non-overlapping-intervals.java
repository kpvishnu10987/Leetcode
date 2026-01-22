class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1) return 0;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1 ; i<n ;i++){
            if(intervals[i][0] >= end){
                result.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start,end});
        return n-result.size();
        
    }
}