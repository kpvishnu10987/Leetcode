class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        generateSubsets(0,nums,allSubsets,subset);
        return allSubsets;
    }
    private void generateSubsets(int i,int[] nums, List<List<Integer>> allSubsets,List<Integer> subset){
        int n = nums.length;
        if(i>=n){
            allSubsets.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        generateSubsets(i+1,nums,allSubsets,subset);
        subset.remove(subset.size()-1);
        generateSubsets(i+1,nums,allSubsets,subset);
    }
}