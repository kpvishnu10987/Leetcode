class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b) -> Long.compare(a[1],b[1]));


        long end = points[0][1];
        int arrows = 1;
        int n = points.length;

        for(int i= 1 ;i<n ; i++){
            if(points[i][0] > end){
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }
}