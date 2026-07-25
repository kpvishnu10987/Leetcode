class Solution {
    public boolean canFinish(int numCourses, int[][] arr) {
        int n = numCourses;
        int in[] = new int[n];
        Stack<Integer> st = new Stack<>();

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] p : arr){
            int a = p[0];
            int b = p[1];
            graph.get(b).add(a);
            in[a]++;
        }

        for(int i = 0 ; i<n ; i++){
            if(in[i] == 0) st.push(i);
        }

        while(!st.isEmpty()){
            int node = st.pop();

            for(int nei : graph.get(node)){
                in[nei]--;
                if(in[nei] == 0){
                    st.push(nei);
                }
            }
        }

        for(int i = 0 ; i<n ; i++){
            if(in[i] != 0) return false;
        }

        return true;


    }
}