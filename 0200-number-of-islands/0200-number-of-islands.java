class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        int islands = 0;
        int[] drow = {0,0,1,-1};
        int[] dcol = {1,-1,0,0};

        for(int i = 0 ; i<n ; i++){
            for(int j =0 ; j<m ; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    Queue<int[]> q = new LinkedList<>();
                    grid[i][j] = '0';
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] node = q.poll();
                        int r = node[0];
                        int c = node[1];
                        for(int k = 0 ; k<4 ; k++){
                            int nr = r + drow[k];
                            int nc = c + dcol[k];
                            if(nr >= 0&& nr < n && nc >=0 && nc <m && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.offer(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }
        }

        return islands;
    }

}