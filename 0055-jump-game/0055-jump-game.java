class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;

        for(int i = 0 ; i<n ;i++){
            if(i > max) return false;
            if(max >= n-1) return true;
            max = Math.max(i+nums[i],max);
        }
        return false;
    }
}