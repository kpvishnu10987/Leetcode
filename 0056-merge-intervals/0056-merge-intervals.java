class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);

        int prev[] = intervals[0];
        List<int[]> list = new ArrayList<>();

        for(int i= 1 ; i<n ; i++){
            if(intervals[i][0] > prev[1]){
                list.add(prev);
                prev = intervals[i];
            }else{
                prev[1] = Math.max(prev[1],intervals[i][1]);
            }
        }

        list.add(prev);
        int[][] ans = new int[list.size()][2];
        for(int i = 0 ; i<list.size() ; i++){
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }

        return ans;
    }
}