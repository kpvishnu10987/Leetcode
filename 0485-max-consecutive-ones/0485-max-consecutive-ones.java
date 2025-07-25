class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int m = 0;
        int sum = 0;
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i] == 0){
                m = Math.max(m,sum);
                sum = 0;
            }else{
                sum += 1;
            }
        }

        return Math.max(m,sum);
    }
}