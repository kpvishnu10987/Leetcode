class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        HashSet<Integer> pairs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairs.add(nums[i] ^ nums[j]);
            }
        }

        boolean[] seen = new boolean[2048];

        for (int p : pairs) {
            for (int x : nums) {
                seen[p ^ x] = true;
            }
        }

        int ans = 0;
        for (boolean b : seen)
            if (b) ans++;

        return ans;
    }
}