class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int result = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(isConnected,visited,i);
                result++;
            }
        }
        return result;
    }

    private void dfs(int[][] isConnected,boolean[] visited,int s){
        visited[s] = true;

        for(int j = 0; j < isConnected.length ; j++){
            if(isConnected[s][j] == 1 && !visited[j]){
                dfs(isConnected,visited,j);
            }
        }
    }
}