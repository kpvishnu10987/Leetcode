class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums,0,ans,new ArrayList<>());
        return ans;
    }

    private void helper(int[] nums,int i,List<List<Integer>> ans,List<Integer> sub){
        if(i == nums.length){
            ans.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        helper(nums,i+1,ans,sub);
        sub.remove(sub.size()-1);
        int j = i;
        while(j+1 < nums.length && nums[j+1] == nums[j]){
            j++;
        }
        helper(nums,j+1,ans,sub);
    }

}