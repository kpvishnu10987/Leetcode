class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        helper(0, 0, candidates, target, ans, sub);
        return ans;
    }

    private void helper(int i, int sum, int[] candidates, int target, List<List<Integer>> ans, List<Integer> sub) {
        if(i == candidates.length || sum >= target){
            if(sum == target){
                ans.add(new ArrayList<>(sub));
            }
            return;
        }

        sub.add(candidates[i]);
        helper(i,sum+candidates[i],candidates,target,ans,sub);
        sub.remove(sub.size()-1);
        helper(i+1,sum,candidates,target,ans,sub);
    }
}