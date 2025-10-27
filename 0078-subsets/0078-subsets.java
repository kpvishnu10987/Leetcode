class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        helper(0, nums, sub, ans);
        return ans;
    }

    private void helper(int i, int[] nums, List<Integer> sub, List<List<Integer>> ans) {

        if (i == nums.length) {

            ans.add(new ArrayList<>(sub));

            return;
        }

        sub.add(nums[i]);
        helper(i + 1, nums, sub, ans);
        sub.remove(sub.size() - 1);

        helper(i + 1, nums, sub, ans);

    }
}