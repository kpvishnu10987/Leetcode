class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        gc(nums,ans,ds,freq);
        return ans;
    }
    private void gc(int[] nums,List<List<Integer>> ans,List<Integer> ds,boolean freq[]){
        int n = nums.length;
        if(ds.size() == n){
                ans.add(new ArrayList<>(ds));
                return;
            }
        for(int i = 0 ;i<n;i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                gc(nums,ans,ds,freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            } 
        }
    }
}