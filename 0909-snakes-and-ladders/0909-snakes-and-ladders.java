class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int dest = n * n;

        boolean[] vis = new boolean[dest+1];
        Queue<Integer>  q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;

        int moves = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i<size ; i++){
                int cur = q.poll();
                if(cur == dest) return moves;

                for(int j = cur + 1 ; j<=Math.min(cur+6,dest) ; j++){
                    int actualCur = getDest(j,board);

                    if(!vis[actualCur]){
                        vis[actualCur] = true;
                        q.offer(actualCur);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private int getDest(int square,int[][] board){
        int n = board.length;

        int q = square-1;
        int rowb = q/n;
        int col = q%n;

        int row = n-1-rowb;

        if(rowb % 2 == 1){
            col = n-1-col;
        }

        if(board[row][col] == -1){
            return square;
        }

        return board[row][col];


        
    }
}