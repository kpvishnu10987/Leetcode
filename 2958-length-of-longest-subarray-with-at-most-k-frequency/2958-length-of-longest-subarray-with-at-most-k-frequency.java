class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        int l = 0;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int r = 0 ; r<n ; r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.get(nums[r]) > k){
                map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                l++;
            }
            max = Math.max(max,r-l+1);
        }

        return max;
    }


}