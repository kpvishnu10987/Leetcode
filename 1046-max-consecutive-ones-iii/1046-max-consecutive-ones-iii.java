class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left=0,right=0;
        int output = 0;
        for(right = 0 ;right < n ;right++){
            if(nums[right] == 0){
                k--;
            }
            while(k<0){
                if(nums[left] == 0){
                    k++;
                }
                left++;
            }
            output = Math.max(output,right-left+1);
        }
        return output;

        
    }
}