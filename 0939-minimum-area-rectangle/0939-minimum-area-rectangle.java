class Solution {
    public int minAreaRect(int[][] points) {
        Set<String> set = new HashSet<>();
        int n = points.length;

        for(int[] p : points){
            set.add(p[0] + "#" + p[1]);
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i<n ; i++){
            for(int j = i+1; j<n ; j++){
                int[] p1 = points[i];
                int[] p2 = points[j];
                if (p1[0] == p2[0] || p1[1] == p2[1])
                    continue;

                if(set.contains(p1[0] + "#" +p2[1]) && set.contains(p2[0] + "#" + p1[1])){
                    int area = Math.abs(p1[0]-p2[0]) * Math.abs(p1[1]-p2[1]);
                    min = Math.min(min,area);
                }else{
                    continue;
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}