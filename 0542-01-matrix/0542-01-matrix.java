class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        for(int[] row : ans){
            Arrays.fill(row,-1);
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};
        
        while(!q.isEmpty()){
            int[] point = q.poll();
            for(int i = 0 ; i<4 ; i++){
                int nr = point[0] + drow[i];
                int nc = point[1] + dcol[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && ans[nr][nc] == -1){
                    ans[nr][nc] = ans[point[0]][point[1]] +1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }

        return ans;
    }
}