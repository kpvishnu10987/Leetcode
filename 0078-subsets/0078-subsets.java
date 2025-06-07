class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int i = 0;i<nums.length;i++){
            int size = ans.size();

            for(int j = 0;j<size;j++){
                List<Integer> subset = new ArrayList<>(ans.get(j));
                subset.add(nums[i]);
                ans.add(subset);

            }
            
        }
        return ans;
        
    }
}