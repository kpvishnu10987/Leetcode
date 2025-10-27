class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, sub, ans);
        return ans;
    }

    private void helper(int start, int[] nums, List<Integer> sub, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(sub));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i])
                continue;

            sub.add(nums[i]);
            helper(i + 1, nums, sub, ans);
            sub.remove(sub.size() - 1);
        }
    }
}