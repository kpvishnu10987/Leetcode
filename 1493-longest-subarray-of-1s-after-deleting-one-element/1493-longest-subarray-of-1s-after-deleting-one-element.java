class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int l = 0;
        int zero = 0;
        int max = 0;

        for(int r = 0 ; r< n ; r++){
            if(nums[r] == 0){
                zero++;
            }

            while(zero > 1){
                if(nums[l] == 0) zero--;
                l++;
            }

            max = Math.max(max,r-l);
        }

        return max;
    }
}