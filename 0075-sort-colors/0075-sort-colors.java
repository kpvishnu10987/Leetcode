class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int i =0; i<n ; i++){
            if(nums[i]==0){
                red++;
            }else if(nums[i] == 1){
                white++;
            }else{
                blue++;
            }
        }
        int count = 0;
        while(red>0 || white >0 || blue >0){
            if(red > 0){
                nums[count] = 0;
                red--;
            }else if(white > 0){
                nums[count] = 1;
                white--;
            }else{
                nums[count] = 2;
                blue--;
            }
            count++;
        }
    }
}