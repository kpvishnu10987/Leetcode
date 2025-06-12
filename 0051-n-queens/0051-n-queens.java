class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for(int i = 0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2*n-1];
        int[] lowerDiagonal = new int[2*n-1];

        gc(0,board,ans,leftRow,upperDiagonal,lowerDiagonal,n);
        return ans;
    }

    private void gc(int col,char[][] board,List<List<String>> ans,int[] leftRow,int[] upperDiagonal,int[] lowerDiagonal,int n){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0;i<n;i++){
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }
        for(int row = 0;row<n;row++){
            if(leftRow[row] == 0 && upperDiagonal[n-1 + col -row] == 0 && lowerDiagonal[row + col] == 0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                upperDiagonal[n-1+col-row] = 1;
                lowerDiagonal[row+col] = 1;
                gc(col+1,board,ans,leftRow,upperDiagonal,lowerDiagonal,n);
                board[row][col] = '.'; 

                leftRow[row] = 0;
                upperDiagonal[n-1+col-row] = 0;
                lowerDiagonal[row+col] = 0;
            }
        }
    }
}