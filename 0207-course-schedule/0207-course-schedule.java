class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }
        int[] in = new int[n];

        for(int p[] : prerequisites){
            graph.get(p[1]).add(p[0]);
            in[p[0]]++;
        }

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i<n ; i++){
            if(in[i] == 0) st.push(i);
        }

        while(!st.isEmpty()){
            int cur = st.pop();
            for(int nei : graph.get(cur)){
                in[nei]--;
                if(in[nei] == 0){
                    st.push(nei);
                }
            }
        }

        for(int i = 0 ; i< n ;i++){
            if(in[i] != 0) return false;
        }
        return true;
    }
}