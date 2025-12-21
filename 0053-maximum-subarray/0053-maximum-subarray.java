class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int n = nums.length;
        int sum = 0;

        for(int i = 0 ;i<n ;i++){
            sum = sum+nums[i];
            maxSum = Math.max(maxSum,sum);
            if(sum<0) sum = 0;
            
        }
        return maxSum;        
    }
}