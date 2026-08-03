class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int f = Integer.MAX_VALUE;
        int s = Integer.MAX_VALUE;

        for(int i = 0 ; i<n ; i++){
            if(nums[i] <= f){
                f = nums[i];
            }else if(nums[i] <= s){
                s = nums[i];
            }else{
                return true;
            }
        }

        return false;
    }
}