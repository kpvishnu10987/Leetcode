class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i<=n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] r : dislikes){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }

        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        for(int i = 0 ;i<n ;i++){
            if(color[i] == -1){
                if(!dfs(1,i,graph,color,n)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int c,int i,List<List<Integer>> graph,int[] color,int n){
        color[i] = c;

        for(int nei : graph.get(i)){
            if(color[nei] == -1){
                if(!dfs(1-c,nei,graph,color,n)){
                    return false;
                }
            }else{
                if(color[nei] == color[i]) return false;
            }
        }

        return true;
    }
}