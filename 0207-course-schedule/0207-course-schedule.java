class Solution {
    public boolean canFinish(int n, int[][] arr) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] in = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] a : arr){
            graph.get(a[1]).add(a[0]);
            in[a[0]]++;
        }

        for(int i = 0 ; i<n ; i++){
            if(in[i] == 0){
                st.push(i);
            }
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

        for(int i = 0 ; i<n ; i++){
            if(in[i] != 0) return false;
        }

        return true;
    }
}