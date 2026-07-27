class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        int l = 0;
        int max = 0,count = 0;
        for(int r = 0 ; r<n ; r++){
            int num = nums[r];
            if(nums[r] == 0) count++;
            while(count > k){
                int left = nums[l];
                if(left == 0) count--;
                l++;
            }

            max = Math.max(max,r-l+1);
        }

        return max;
    }
}