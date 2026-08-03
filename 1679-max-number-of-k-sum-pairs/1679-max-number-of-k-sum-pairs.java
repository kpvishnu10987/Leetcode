class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int l = 0;
        int r = n-1;
        int ans = 0;

        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum == k){
                ans++;
                l++;
                r--;
            }else if(sum > k){
                r--;
            }else{
                l++;
            }
        }

        return ans;
    }
}