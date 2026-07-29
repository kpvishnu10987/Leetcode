class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int n = nums.length;

        for(int num : nums){
            l = Math.max(num,l);
            r += num;
        }

        while(l < r){
            int mid = l + (r-l)/2;

            if(can(mid,nums,k)){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return l;
    }

    private boolean can(int k,int[] nums,int days){
        int pre = 0;
        int n = nums.length;
        int cur = 1;

        for(int i = 0 ; i<n ; i++){
            if(pre + nums[i] > k){
                cur++;
                pre = nums[i];
            }else{
                pre += nums[i];
            }
            if(cur > days) return false;
        }

        return cur <= days;
    }
}