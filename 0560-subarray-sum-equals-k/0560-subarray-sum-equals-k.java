class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>(); // sum,freq
        int ans=0;
        map.put(0,1);
        int pre = 0;
        for(int i = 0 ; i<n ; i++){
            pre += nums[i];
            int need = pre-k;
            if(map.containsKey(need)){
                ans += map.get(need);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return ans;
    }
}