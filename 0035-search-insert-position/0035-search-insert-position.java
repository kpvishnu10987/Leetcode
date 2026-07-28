class Solution {
    public int searchInsert(int[] nums, int target) {

        int n = nums.length;

        int l = 0;
        int r = n;

        while(l < r){
            int mid = l + (r-l)/2;
            int num =  nums[mid];

            if(num >= target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;

    }
}