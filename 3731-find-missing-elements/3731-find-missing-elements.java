class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
            set.add(num);
        }

        int num = min;
        while(num <= max){
            if(!set.contains(num)) ans.add(num);
            num++;
        }

        return ans;
    }
}