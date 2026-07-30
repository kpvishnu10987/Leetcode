class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int maxnum = 0;
        int maxcount = 0;

        for(int i = 0 ; i<n ; i++){
            if(maxnum != nums[i]){
                maxcount--;
                if(maxcount < 0){
                    maxcount = 1;
                    maxnum = nums[i];
                }
            }else{
                maxcount++;
            }
        }

        return maxnum;
    }
}