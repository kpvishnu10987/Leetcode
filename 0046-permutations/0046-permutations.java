class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        gc(0,nums,ans);
        return ans;
    }
    private void gc(int index,int[] nums,List<List<Integer>> ans){
        int n = nums.length;
        if(index == n){
            List<Integer> ds = new ArrayList<>();
            for(int i = 0;i<n;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index;i<n;i++){
            swap(index,i,nums);
            gc(index+1,nums,ans);
            swap(index,i,nums);
        }

    }
    private void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}