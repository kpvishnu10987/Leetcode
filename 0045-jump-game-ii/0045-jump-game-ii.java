class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int cur = 0;
        int far = 0;
        int j = 0;

        for(int i = 0 ; i<n-1 ; i++){
            cur = Math.max(cur,i+nums[i]);

            if(i == far){
                far = cur;
                j++;
            }
        }
        return j;
    }
}