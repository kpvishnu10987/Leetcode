class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] ans = new int[n];
        int idx = 0;

       int[] in = new int[n];

       Stack<Integer> st = new Stack<>();
       List<List<Integer>> graph = new ArrayList<>();

       for(int i = 0 ; i<n ;i++){
            graph.add(new ArrayList<>());
       }

       for(int i = 0 ; i<prerequisites.length ; i++){
            int[] e = prerequisites[i];
            graph.get(e[1]).add(e[0]);
            in[e[0]]++;
       } 

       for(int i = 0; i<n ; i++){
        if(in[i] == 0){
            st.push(i);
            ans[idx++]  = i;
        }
       }

       while(!st.isEmpty()){
        int node = st.pop();
        for(int nei : graph.get(node)){
            in[nei]--;
            if(in[nei] == 0){
                st.push(nei);
                ans[idx++] = nei;
            }
        }
       }

       for(int i = 0 ; i<n ;i++){
        if(in[i] > 0) return new int[0];
       }

       return ans;
    }
}