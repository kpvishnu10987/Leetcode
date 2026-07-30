class Solution {
    public int trap(int[] nums) {
        int n = nums.length;

        int[] rmax = new int[n];
        int max = nums[n-1];
        rmax[n-1] = 0;
        for(int i = n-2 ; i>= 0 ; i--){
            rmax[i] = max;
            max = Math.max(max,nums[i]);
        }

        int lmax = 0;
        int water = 0;

        for(int i = 0 ; i<n ;i++){
            int h = Math.min(lmax,rmax[i]);
            water += Math.max(0,h-nums[i]);
            lmax =Math.max(lmax,nums[i]);
        }

        return water;
    }
}