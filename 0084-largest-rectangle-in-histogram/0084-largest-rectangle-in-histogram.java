class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];

        for(int i = n-1; i>=0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nse[i] = n;
            }else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();

        for(int i=0 ; i<n ; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = st.peek();
            }
            st.push(i);
        }

        int ans = 0;
        for(int i = 0 ; i<n ; i++){
            int h = arr[i];
            int w = nse[i] - pse[i]-1;

            ans = Math.max(ans,h * w);
        }
        return ans;
    }
}