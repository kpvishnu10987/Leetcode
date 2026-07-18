class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;

        int l = 1;
        int r = 0;
        for(int num : nums){
            r = Math.max(num,r);
        }

        while(l < r){
            int mid = l + (r-l)/2;

            long op = 0;
            for(int num : nums){
                op += (num-1)/mid;
            }
            if(op <= maxOperations){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}