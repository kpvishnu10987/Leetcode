class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        helper(0, n, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int start, int n, int[] candidates, int target, List<Integer> sub, List<List<Integer>> ans) {
        if (target == 0) {
                ans.add(new ArrayList<>(sub));
                return;
            
        }

        for(int i = start ; i<n ; i++){
            if(i >start && candidates[i] == candidates[i-1]) continue;

            if(candidates[i] > target) break;
            sub.add(candidates[i]);
            helper(i+1, n, candidates, target - candidates[i], sub, ans);
            sub.remove(sub.size() - 1);
        }
    }
}