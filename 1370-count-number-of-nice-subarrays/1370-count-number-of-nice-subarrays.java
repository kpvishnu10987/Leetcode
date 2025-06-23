class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
        
    }
    private int helper(int[] nums,int k){
        int temp =k;
        int n = nums.length;
        int count = 0;
        int left = 0;
        int odd = 0;
        for(int right = 0;right < n ;right++){
            if(nums[right]%2 != 0){
                odd++;
            }
            
            while(odd > k){
                if(nums[left]%2 != 0){
                    odd--;
                }
                left++;
            }

            count += right-left+1;
        }
        return count;
    }
}