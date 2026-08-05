class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int maxp[] = new int[n];
        int minp[] = new int[n];

        maxp[0] = nums[0];
        minp[0] = nums[0];
        int max = nums[0];

        for(int i = 1; i<n ;i++){
            maxp[i] = Math.max(nums[i],Math.max(nums[i] * maxp[i-1] , nums[i] * minp[i-1]));
            minp[i] = Math.min(nums[i],Math.min(nums[i] * maxp[i-1] , nums[i] * minp[i-1]));
            max = Math.max(maxp[i],max);
        }

        return max;
    }
}