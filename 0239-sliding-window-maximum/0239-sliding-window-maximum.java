class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k<=0) return new int[0];
        int n = nums.length;
        int[] output = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int index = 0;

        for(int i = 0 ;i < n ;i++){
            if(!dq.isEmpty() && dq.peekFirst() < i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i >= k-1){
                output[index++] = nums[dq.peekFirst()];
            }
        }
        
        return output;
        
    }
}