class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
    private int helper(int[] nums,int k){
        int distinct = 0;
        int n = nums.length;
        int count = 0;
        int left = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int right = 0;right<n;right++){
            
            if(!map.containsKey(nums[right])){
                distinct++;
            }
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(distinct>k){
                int num = nums[left];
                map.put(num,map.get(num)-1);
                left++;
                if(map.get(num)==0){
                    map.remove(num);
                    distinct--;
                }
            }

            count += right-left+1;

        }
        return count;

    }
}