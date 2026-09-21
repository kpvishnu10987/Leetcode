class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;

        for(int i = 0 ; i<n ; i++){
            sum += nums[i];

            int rem = sum % k;
            if(rem < 0){
                rem += k;
            }
            count += map.getOrDefault(rem,0);

            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}