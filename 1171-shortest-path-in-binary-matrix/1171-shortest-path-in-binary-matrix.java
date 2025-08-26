class Pair{
    int row;
    int col;
    int pdis;
    Pair(int _row,int _col,int _pdis){
        this.row = _row;
        this.col = _col;
        this.pdis = _pdis;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(grid[0][0] != 0) return -1;
        if(n==1 && m==1) return 1;
        if(grid[n-1][m-1] != 0 ) return -1;
        int[][] dis = new int[n][m];
        for(int row[] : dis){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        int[] drow = {-1,-1,0,+1,+1,+1,0,-1};
        int[] dcol = {0,+1,+1,+1,0,-1,-1,-1};

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0,1));

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int d = q.peek().pdis;
            q.poll();
            for(int i = 0 ; i<8 ; i++){
                int nr = r+drow[i];
                int nc = c+dcol[i];
                if(nr >= 0 && nr<n && nc >= 0 && nc <m && grid[nr][nc] == 0){
                    if (dis[nr][nc] == Integer.MAX_VALUE) {
                        dis[nr][nc] = d + 1;
                        q.offer(new Pair(nr, nc, d+1));
                    }
                }
            }
        }

        return dis[n-1][m-1] == Integer.MAX_VALUE ? -1 : dis[n-1][m-1];

    
        
    }
}