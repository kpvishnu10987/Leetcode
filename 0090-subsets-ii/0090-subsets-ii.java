class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
          List<List<Integer>> ans  = new ArrayList<>();
          List<Integer> subset = new ArrayList<>();
          Arrays.sort(nums);
          gc(0,nums,ans,subset);
          return ans;
    }
    private void gc(int start,int[] nums, List<List<Integer>> ans,List<Integer> subset){
        int n = nums.length;
        ans.add(new ArrayList<>(subset));
         
        for(int i = start ; i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]) continue;

            subset.add(nums[i]);
            gc(i+1,nums,ans,subset);
            subset.remove(subset.size()-1);
        }

    }
}