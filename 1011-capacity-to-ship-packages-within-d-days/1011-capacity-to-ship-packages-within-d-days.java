class Solution {
    public int shipWithinDays(int[] nums, int days) {
        int n =  nums.length;

        int l = 0;
        int r = 0;
        for(int i = 0 ; i<n ; i++){
            r += nums[i];
            l = Math.max(l,nums[i]);
        }

        while(l < r){
            int mid = l + (r-l)/2;

            if(can(mid,nums,days)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    private boolean can(int k,int[] arr,int days){
        int n = arr.length;
        int day = 1;
        int pre = 0;
        for(int i = 0 ; i<n ;i++){
            if(pre+arr[i] > k){
                pre = arr[i];
                day++;
            }else{
                pre += arr[i];
            }
        }
        return day <= days;
    }
}