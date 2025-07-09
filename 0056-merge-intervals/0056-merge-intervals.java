class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

        int[] newInt = intervals[0];
        for(int i = 1 ; i< intervals.length;i++){
            if(newInt[1] >= intervals[i][0]){
                newInt[1] = Math.max(newInt[1],intervals[i][1]);
            }else{
                result.add(newInt);
                newInt = intervals[i];
            }
        }
        result.add(newInt);
        return result.toArray(new int[result.size()][]);
    }
}