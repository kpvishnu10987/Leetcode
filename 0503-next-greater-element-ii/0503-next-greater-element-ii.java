class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        int n = nums.length;

        for(int i = 2*n-1;i>=0;i--){
            int num = nums[i%n];
            while(!st.isEmpty() && num >= st.peek()){
                st.pop();
            }
            if(i<n){
                ans[i] = st.isEmpty()?-1:st.peek();
            }
            st.push(num);
        }
        return ans;
        
    }
}