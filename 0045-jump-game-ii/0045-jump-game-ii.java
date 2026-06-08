class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int cur = 0;
        int far = 0;
        int jumps = 0;
        for(int i = 0; i<n-1 ; i++){
            far = Math.max(far,i+nums[i]);
            if(i == cur){
                jumps++;
                cur = far;
            }
        }

        return jumps;
    }
}