class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        int r = n-1;
        int l = 0;
        while(l < r){
            int mid = l+(r-l)/2;
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid+1]){
                    l = mid+2;
                }else{
                    r = mid;
                }
            }else{
                if(nums[mid] == nums[mid-1]){
                    l = mid+1;
                }else{
                    r = mid;
                }
                
            }
        }

        return nums[l];
    }
}