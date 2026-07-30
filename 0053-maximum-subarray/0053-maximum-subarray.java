class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int sum = nums[0];
        int max = nums[0];

        for(int i =1 ; i<n; i++){
            sum = Math.max(nums[i],sum+nums[i]);
            max = Math.max(sum,max);
        }

        return max;
    }
}