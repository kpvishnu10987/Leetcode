class Pair{
    int dis;
    int row;
    int col;
    public Pair(int d,int r ,int c){
        this.dis = d;
        this.row = r;
        this.col = c ;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.dis-y.dis);
        int[][] dist = new int[n][m];
        
        for(int i = 0 ;i<n ; i++){
            for(int j =0 ; j<m ; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        pq.offer(new Pair(0,0,0));
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int d = curr.dis;
            int r = curr.row;
            int c = curr.col;
            if (d > dist[r][c]) continue;
            if(r == n-1 && c == m-1) return d;

            for(int i = 0 ; i<4 ; i++){
                int nr = r+drow[i];
                int nc = c+dcol[i];
                
                if(nr >= 0 && nc >=0 && nr<n && nc < m){
                    int nd = Math.max(Math.abs(heights[r][c]-heights[nr][nc]),d);
                    if(nd < dist[nr][nc]){
                        dist[nr][nc] = nd;
                        pq.offer(new Pair(nd,nr,nc));
                    }
                }
            }
        }
        return 0;
    }
}