class Solution {
    List<List<Integer>> ans;
    int[] nums;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        ans = new ArrayList<>();
        boolean[] vis = new boolean[n];

        f(0,new ArrayList<>(),vis);
        return ans;
    }

    private void f(int start,List<Integer> sub,boolean[] vis){
        if(sub.size() == n){
            ans.add(new ArrayList<>(sub));
            return;
        }

        for(int i = 0 ; i<n ; i++){
            if(!vis[i]){
                vis[i] = true;
                sub.add(nums[i]);
                f(i+1,sub,vis);
                vis[i] = false;
                sub.remove(sub.size()-1);
            }
        }
    }
}