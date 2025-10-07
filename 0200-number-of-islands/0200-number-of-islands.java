class Edge{
    int src;
    int dest;
    public Edge(int s,int d){
        this.src = s;
        this.dest = d;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Edge> q = new LinkedList();

        int cnt = 0 ;
        for(int i = 0 ; i<n ;i++){
            for(int j = 0 ; j<m ;j++){
                if(vis[i][j] != 1 && grid[i][j] == '1'){
                    cnt++;
                    q.offer(new Edge(i,j));
                    bfs(grid,vis,q,n,m);
                }
            }
        }
        return cnt;
    }
    public void bfs(char[][] grid,int[][] vis,Queue<Edge> q,int n ,int m){

        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};

        while(!q.isEmpty()){
            Edge e = q.poll();
            int start = e.src;
            int end = e.dest;
   
            for(int i = 0; i<4 ; i++){
                int nrow = start+drow[i];
                int ncol = end + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] != 1 && grid[nrow][ncol] == '1'){
                    vis[nrow][ncol] = 1;
                    q.offer(new Edge(nrow,ncol));
                }
            }

        }

    }
}