class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if(n <= 2) return n;
        if(n == 3) return 4;



        int ans = 0;

        for(int num : nums){
            ans |= num;
           
        }
        return ans+1;
    }
}