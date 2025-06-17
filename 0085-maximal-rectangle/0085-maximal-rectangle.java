class Solution {
    private int LargestHist(int[] prefixSum){
        int n = prefixSum.length;
        int nse = 0;
        int pse = 0;
        int element = 0;
        int maxarea = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0 ; i<n ; i++){
            while(!st.isEmpty() && prefixSum[st.peek()] > prefixSum[i]){
                element = prefixSum[st.peek()];
                st.pop();
                nse = i;
                pse = st.isEmpty()?-1:st.peek();
                maxarea = Math.max(maxarea,element*(nse-pse-1));
            }
            st.push(i);
            
        }
        while(!st.isEmpty()){
                element = prefixSum[st.peek()];
                st.pop();
                nse = n;
                pse = st.isEmpty()?-1:st.peek();
                maxarea = Math.max(maxarea,element*(nse-pse-1));
            }
        return maxarea;

    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] prefixSum = new int[n][m];

        for(int j = 0 ;j < m;j++){
            int sum = 0;
            for(int  i = 0; i< n ;i++){
                if(matrix[i][j] == '1'){
                    sum = sum +1;
                }else{
                    sum = 0;
                }
                prefixSum[i][j] = sum ;
            }
        }
        int maxArea = 0;
        for(int i = 0;i< n ;i++){
            maxArea = Math.max(maxArea,LargestHist(prefixSum[i]));
        }
        return maxArea;
        
    }
}