class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int l = 0;
        int r = n-1;


        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[l] <= nums[mid]){
                min = Math.min(min,nums[l]);
                l = mid+1;
            }else if(nums[mid] <= nums[r]){
                min = Math.min(min,nums[mid]);
                r = mid-1;
            }
        }
        return min;
    }
}