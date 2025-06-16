class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse = n;
        int pse = -1;
        int maxarea = 0;
        int element = 0;
        
        Stack<Integer> st = new Stack<>();
        //element * (nseindex-pseindex -1)//-1 for 0-indexing
        for(int i =0 ;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                element = heights[st.peek()];
                st.pop();
                nse = i;
                pse = st.isEmpty()?-1:st.peek();
                maxarea = Math.max(element*(nse-pse-1),maxarea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            element = heights[st.peek()];
            st.pop();
            nse = n;
            pse = st.isEmpty()?-1:st.peek();
            maxarea = Math.max(element*(nse-pse-1),maxarea);
        }

        return maxarea;
        
        
    }
}