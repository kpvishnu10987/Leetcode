class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        helper(0,n,candidates,target,new ArrayList<>(),ans);
        return ans;
    }

    private void helper(int i,int n,int[] candidates,int target,List<Integer> sub,List<List<Integer>> ans){
      
        if (target == 0) {
        ans.add(new ArrayList<>(sub));
        return;
    }

    if (i == n || target < 0) {
        return;
    }
        


            sub.add(candidates[i]);
            helper(i,n,candidates,target-candidates[i],sub,ans);
            sub.remove(sub.size()-1);
            helper(i+1,n,candidates,target,sub,ans);

       

    }
}