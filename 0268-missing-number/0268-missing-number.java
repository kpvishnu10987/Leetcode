class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int now = 0;
        for(int i = 0;i<n;i++){
            sum += i;
            now += nums[i];
        }
        sum += n;
        return sum-now;
        
    }
}