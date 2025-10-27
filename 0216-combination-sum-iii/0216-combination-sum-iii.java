class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        helper(1,k,n,ans,sub);
        return ans;
    }
    private void helper(int i,int k,int n,List<List<Integer>> ans,List<Integer> sub){
        if(i == 10){
            if(sub.size() == k && n == 0){
                ans.add(new ArrayList<>(sub));
            }
            return;
        }
        sub.add(i);
        helper(i+1,k,n-i,ans,sub);
        sub.remove(sub.size()-1);
        helper(i+1,k,n,ans,sub);
    }
}