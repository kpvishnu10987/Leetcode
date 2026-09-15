class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;

        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1 ; i>=0 ; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                nge[i] = n;
            }else{
                nge[i] = st.peek();
            }

            st.push(i);
        }

        int[] ans = new int[n];
        for(int i = 0 ; i<n ; i++){
            if(nge[i] == n){
                ans[i] = 0;
                continue;
            }
            ans[i] = nge[i] - i;
        }
        return ans;
    }
}