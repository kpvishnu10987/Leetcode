class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};

        for(int i = 0 ; i<n ; i++){
            if(board[i][0] == 'O'){
                q.offer(new int[]{i,0});
                visited[i][0] = 1;
            }
            if(board[i][m-1] == 'O'){
                visited[i][m-1] = 1;
                q.offer(new int[]{i,m-1});
            }
        }
        for(int i = 0 ; i<m ; i++){
            if(board[0][i] == 'O'){
                q.offer(new int[]{0,i});
                visited[0][i] = 1;
            }
            if(board[n-1][i] == 'O'){
                q.offer(new int[]{n-1,i});
                visited[n-1][i] = 1;
            }
        }

        while(!q.isEmpty()){
            int[] point = q.poll();
            for(int i = 0 ; i<4 ; i++){
                int nr = point[0] + drow[i];
                int nc = point[1] + dcol[i];
                if(nr >= 0 && nr <n && nc >=0 && nc <m && visited[nr][nc] == 0 && board[nr][nc] == 'O'){
                    visited[nr][nc] = 1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        for(int i = 0 ; i<n ; i++){
            for(int j = 0; j<m ; j++){
                if(visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}