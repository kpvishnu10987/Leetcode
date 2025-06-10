class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int numberOfSub = 1<<n;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<=numberOfSub-1;i++){
        List<Integer> subset = new ArrayList<>();
            for(int j = 0;j<=n-1;j++){
                int k = 1<<j;
                if((i & k) != 0){
                    subset.add(nums[j]);
                }
            }
            List<Integer> sub = new ArrayList<>(subset);
            
            ans.add(sub);
        }
        return ans;
        
    }
}