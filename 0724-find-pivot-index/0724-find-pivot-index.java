class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];

        suf[n-1] = 0;

        for(int i = n-2 ; i>=0 ; i--){
            suf[i] = nums[i+1] + suf[i+1];
        }

        int pre = 0;
        for(int i = 0 ;i<n ; i++){
            if(pre == suf[i]) return i;
            pre += nums[i];
        }

        return -1;
        
    }
}