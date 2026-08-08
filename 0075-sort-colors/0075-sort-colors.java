class Solution {
    public void sortColors(int[] nums) {
        int z = 0;
        int o = 0;
        int t = 0;
        for(int num : nums){
            if(num == 0){
                z++;
            }else if(num == 1){
                o++;
            }else{
                t++;
            }
        }

        for(int i = 0 ; i<nums.length; i++){
            if(z > 0){
                nums[i] = 0;
                z--;
            }else if(o > 0){
                o--;
                nums[i] = 1;
            }else{
                t--;
                nums[i] = 2;
            }
        }
    }
}