class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates, target, ans, sub);
        return ans;
    }

    private void helper(int start,int[] candidates, int target, List<List<Integer>> ans, List<Integer> sub) {
        if(target == 0){
            ans.add(new ArrayList<>(sub));
            return;
        }
       for(int i = start ; i<candidates.length ;i++){
            if(i > start && candidates[i-1] == candidates[i]) continue;

            if(candidates[i] > target) continue;

            sub.add(candidates[i]);
            helper(i+1,candidates,target-candidates[i],ans,sub);
            sub.remove(sub.size()-1);
       }

    }
}