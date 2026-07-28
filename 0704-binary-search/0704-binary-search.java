class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0;
        int r = n-1;

        while(l <=r){
            int mid = l + (r-l)/2;
            int num =  nums[mid];

            if(num == target){
                return mid;
            }else if(num > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
}