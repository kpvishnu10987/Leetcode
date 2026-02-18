class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ng = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1 ;i>=0 ; i--){
            if(st.isEmpty()){
                ng[i] = i;
                st.push(i);
            }else{
                while(!st.isEmpty() && (temperatures[i] >= temperatures[st.peek()])){
                    st.pop();
                }

                if(st.isEmpty()){
                    ng[i] = i;
                    st.push(i);
                }else{
                    ng[i] = st.peek();
                    st.push(i);
                }
            }
        }

        int[] ans = new  int[n];
        for(int i =0 ; i<n ; i++){
            ans[i] = ng[i] - i;
        }

        return ans;
        
    }
}