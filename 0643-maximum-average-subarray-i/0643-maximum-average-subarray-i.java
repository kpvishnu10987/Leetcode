class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int n = nums.length;

        int l = 0;
        double sum = 0;
        double ans =(double) -100000;

        for(int i= 0 ; i<n ; i++){
            sum +=(double) nums[i];
            if(i-l+1 < k) continue;
            if(i-l+1 > k){
                sum -=(double) nums[l];
                l++;
            }
             
            ans = Math.max(ans,sum/(double) k);
            System.out.print(sum/(double) k);
        }

        return ans;
    }
}