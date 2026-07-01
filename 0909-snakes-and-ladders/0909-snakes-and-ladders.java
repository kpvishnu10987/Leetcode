class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        boolean[] vis = new boolean[n*n+1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        vis[1] = true;

        int moves = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i<size ; i++){
                int cur = q.poll();
                if(cur == n*n) return moves;
                for(int dice = 1 ; dice <=6 && cur+dice <=n*n ; dice++){
                    int next = cur+dice;
                    int[] pos = getpos(next,n);
                    int row = pos[0];
                    int col = pos[1];

                    if(board[row][col] != -1){
                        next = board[row][col];
                    }
                    if(!vis[next]){
                        vis[next] = true;
                        q.offer(next);
                    }
                }
            }
                moves++;
        }

        return -1;
    }

    private int[] getpos(int cur,int n){
        int rb = (cur-1)/n;
        int row = n-rb-1;
        int col = (cur-1)%n;
        if(rb %2 ==1){
            col = n-1-col;
        }

        return new int[]{row,col};
    }
}