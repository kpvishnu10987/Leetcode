class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left=0,right=0,output=0,zeros=0;
        while(right < n){
            if(nums[right] == 0) zeros++;
            if(zeros > k){
                if(nums[left] == 0) zeros--;
                left++;
            }
            if(zeros <= k){
                output = Math.max(output,right-left+1);
            }
            right++;
        }
        return output;

        
    }
}