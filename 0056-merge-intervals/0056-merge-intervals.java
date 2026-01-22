class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length <=1) return intervals;

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1 ;i<intervals.length; i++){
            if(intervals[i][0] <= end){
                end = Math.max(end,intervals[i][1]);
            }else{
                result.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start,end});
        return result.toArray(new int[result.size()][]);

    }
}