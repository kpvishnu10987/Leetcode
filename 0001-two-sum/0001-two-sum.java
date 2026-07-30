class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i<n ; i++){
            int num = nums[i];
            int req = target-num;
            if(map.containsKey(req)) return new int[]{i,map.get(req)};
            map.put(num,i);
        }

        return new int[0];
    }
}