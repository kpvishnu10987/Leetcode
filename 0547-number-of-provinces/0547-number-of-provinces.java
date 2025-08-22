class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int result = 0;

        for(int i = 0 ; i<n ; i++){
            if(!visited[i]){
                dfs(isConnected,visited,result,i);
                result++;
            }
        }
        return result;
    }
    private void dfs(int[][] isConnected,boolean[] visited,int result,int s){
        visited[s] = true;
        for(int i = 0 ; i<isConnected.length; i++){
            if(isConnected[s][i] == 1 && !visited[i]){
                dfs(isConnected,visited,result,i);
            }
        }
    }
}