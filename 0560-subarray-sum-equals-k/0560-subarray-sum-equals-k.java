class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0,1);
        int sum = 0;

        for(int i = 0 ; i<n ; i++){
            sum += nums[i];
            int need = sum - k;
            if(map.containsKey(need)){
                ans += map.get(need);
            }

            map.put(sum,map.getOrDefault(sum,0) + 1);
        }

        return ans;
    }
}