class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int len = 0;

        for(int i = 0 ; i<n ; i++){
            if(nums[i] == 0){
                len++;
            }else{
                int temp = nums[i];
                nums[i] = nums[i-len];
                nums[i-len] = temp;
            }
        } 

        
    }
}