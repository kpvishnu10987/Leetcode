class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0;
        int r = n-1;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;

            if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target <= nums[mid]){
                    r = mid;
                }else{
                    l = mid+1;
                }
            }else if(nums[mid] <= nums[r]){
                if(target >= nums[mid] && target <= nums[r]){
                    l = mid;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}