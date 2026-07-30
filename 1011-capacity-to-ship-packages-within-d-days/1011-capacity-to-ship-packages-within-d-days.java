class Solution {
    public int shipWithinDays(int[] nums, int days) {
        int n = nums.length;
        int l = 0;
        int r = 0;

        for(int i = 0 ; i<n ;i++){
            r += nums[i];
            l = Math.max(nums[i],l);
        }

        while( l < r){
            int mid = l + (r-l)/2;

            if(can(mid,nums,days)){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return l;
    }

    private boolean can(int cap,int[] nums,int days){
        int curdays = 1;
        int sum = 0;

        for(int i = 0 ;i<nums.length ; i++){
            if(sum + nums[i] > cap){
                curdays++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            if(curdays > days) return false;
        }
        return curdays <= days;
    }
}