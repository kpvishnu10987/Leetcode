class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longlen = 0;

        for(int num : set){
            if(set.contains(num-1)){
                continue;
            }else{
                int cur = num;
                int len = 1;
                while(set.contains(cur+1)){
                    cur++;
                    len++;
                }
                longlen = Math.max(len,longlen);
            }
        }

        return longlen;
    }
}