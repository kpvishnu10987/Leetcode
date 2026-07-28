class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int max = 0;

        for(int i = 0 ; i<=n ; i++){
            while(!st.isEmpty() && (i == n || arr[st.peek()] >= arr[i])){
                int h = arr[st.pop()];
                int r = i;
                int l = st.isEmpty()? -1 : st.peek();
                int w = r-l-1;

                max = Math.max(max,h*w);
            }
            st.push(i);
        }

        return max;
    }
}