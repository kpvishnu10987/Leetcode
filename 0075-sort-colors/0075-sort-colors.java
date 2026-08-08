class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0;
        int mid = 0;
        int r = n-1;

        while(mid <= r){
            if(nums[mid] == 1){
                mid++;
                continue;
            }

            if(nums[mid] == 2){
                nums[mid] = nums[r];
                nums[r] = 2;
                r--;
            }else{
                nums[mid] = nums[l];
                nums[l] = 0;
                mid++;
                l++;
            }
        }
        
    }
}