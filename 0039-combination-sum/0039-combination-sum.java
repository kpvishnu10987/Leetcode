class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> subset = new ArrayList<>();
        generateCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
    private void generateCombinations(int i,int[] candidates, int target,List<List<Integer>> ans,List<Integer> subset){
        int n = candidates.length;
        if(i==n){
            if(target == 0){
                ans.add(new ArrayList<>(subset));
            }
            return;
        }
        if(candidates[i] <= target){
            subset.add(candidates[i]);
            generateCombinations(i,candidates,target-candidates[i],ans,subset);
            subset.remove(subset.size()-1);
        }
        generateCombinations(i+1,candidates,target,ans,subset);
    }
}