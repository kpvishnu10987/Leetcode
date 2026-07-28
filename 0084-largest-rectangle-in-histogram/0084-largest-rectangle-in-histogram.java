class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;

        int[] nse = new int[n];
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = n-1 ; i>=0 ; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        while(!st.isEmpty()) st.pop();

        for(int i = 0 ; i<n ; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        int max = 0;

        for(int i = 0 ; i<n ; i++){
            int h = nums[i];
            int w = nse[i]-pse[i]-1;
            max = Math.max(max, h*w);
        }

        return max;
    }
}