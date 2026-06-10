class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        if(n == 0){
            int[][] me = new int[1][2];
            me[0][0] = newInterval[0];
            me[0][1] = newInterval[1];
            return me;
        }

        int i = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        boolean added = false;

        while(i < n){
            int[] interval = intervals[i];
            if(start > interval[1]){
                ans.add(interval);
                i++;
                continue;
            }else{
                added = true;
                start = Math.min(start,interval[0]);
                while(i < n && end >= intervals[i][0]){
                    end = Math.max(end,intervals[i][1]);
                    i++;
                }
                ans.add(new int[]{start,end});
                break;
                
            }
        }
        if(!added){
            ans.add(newInterval);
        }

        while(i < n){
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[0][]);
    }
}