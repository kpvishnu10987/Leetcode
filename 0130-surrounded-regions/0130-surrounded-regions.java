class Solution {
    char[][] board;
    int n;
    int m;
    public void solve(char[][] board) {
        this.board = board;
        n = board.length;
        m = board[0].length;

        for(int i = 0 ; i<n ; i++){
            bfs(i,0);
            bfs(i,m-1);
        }

        for(int i = 0 ;i<m ; i++){
            bfs(0,i);
            bfs(n-1,i);
        }

        for(int i = 0 ; i<n; i++){
            for(int j = 0 ; j<m ; j++){
                if(board[i][j] == 'Z'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }


    }

    private void bfs(int i,int j){
        if(i < 0 || j <0 || i > n-1 || j>m-1) return;
        if(board[i][j] != 'O') return;

        board[i][j] = 'Z';

        bfs(i+1,j);
        bfs(i,j+1);
        bfs(i-1,j);
        bfs(i,j-1);
    }
}