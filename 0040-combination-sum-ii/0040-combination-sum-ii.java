class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> subset = new ArrayList<>();
        gc(0,candidates,target,ans,subset);
        return ans;
    }
    private void gc(int index,int[] candidates, int target,List<List<Integer>> ans,List<Integer> subset){
        int n = candidates.length;
        if(target == 0){
            ans.add(new ArrayList<>(subset));
            return;
        }
        for(int i = index;i<n;i++){
            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i] > target) break;
            subset.add(candidates[i]);
            gc(i+1,candidates,target-candidates[i],ans,subset);
            subset.remove(subset.size()-1);
        }
    }
}