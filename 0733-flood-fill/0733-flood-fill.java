class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        int co = image[sr][sc];
        int[][] visited = new int[n][m];
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int[] point = q.poll();
            for(int i = 0 ;i<4 ;i++){
                int r = point[0] + drow[i];
                int c= point[1] + dcol[i];
                if(r >= 0 && r<n && c >=0 && c <m && visited[r][c] != 1 && image[r][c] == co ){
                    visited[r][c] = 1;
                    image[r][c] = color;
                    q.offer(new int[]{r,c});
                }
            }
        }

        return image;
        
    }
}