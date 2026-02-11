class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        int n = nums.length;
        helper(0,n,nums,ans,sub);
        return ans;
    }

    private void helper(int i,int n,int[] nums,List<List<Integer>> ans,List<Integer> sub)
    {
        if(i == n){
            if(!ans.contains(sub)){
                ans.add(new ArrayList<>(sub));
            }
            return;
        }
        sub.add(nums[i]);
        helper(i+1,n,nums,ans,sub);
        sub.remove(sub.size()-1);
        helper(i+1,n,nums,ans,sub);
    }
}