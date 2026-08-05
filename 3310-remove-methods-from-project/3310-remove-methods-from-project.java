class Solution {
    List<List<Integer>> graph;
    public List<Integer> remainingMethods(int n, int k, int[][] arr) {
        List<Integer> ans = new ArrayList<>();
        graph = new ArrayList<>();
        for(int i=0 ; i<n ;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] a : arr){
            graph.get(a[0]).add(a[1]);
        }

        boolean[] connec = new boolean[n];
        connec[k] = true;
        dfs(k,connec);

        for(int i = 0 ;i<n ;i++){
            if(connec[i]) continue;
            for(int nei : graph.get(i)){
                if(!connec[nei]) continue;
                for(int x = 0 ;x<n ;x++) ans.add(x);
                return ans;
            }
        }
        for(int i = 0 ; i<n ; i++){
            if(!connec[i]) ans.add(i);
        }
        return ans;
    }

    private void dfs(int k,boolean[] connec){
        for(int nei : graph.get(k)){
            if(!connec[nei]){
                connec[nei] = true;
                dfs(nei,connec);
            }
        }
    }
}