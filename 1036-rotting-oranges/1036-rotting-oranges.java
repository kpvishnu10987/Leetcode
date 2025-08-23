class Pair{
    int row;
    int col;
    int tm;
    Pair(int _row,int _col, int _tm){
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }

}
class Solution {

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        int cnt_fresh = 0;
        int cnt = 0;

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                }else{
                    if(grid[i][j] == 1){
                        cnt_fresh += 1;
                    }
                }
            }
        }
        int tm = 0;
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,+1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(tm,t);
            q.remove();
            for(int i = 0 ; i<4 ; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && nrow <n && ncol >=0 && ncol <m && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1 ){
                    cnt++;
                    q.offer(new Pair(nrow,ncol,t+1));
                    visited[nrow][ncol] = 1; 
                }
            }
        }

        if (cnt != cnt_fresh) return -1;
        return tm;
        
    }
}