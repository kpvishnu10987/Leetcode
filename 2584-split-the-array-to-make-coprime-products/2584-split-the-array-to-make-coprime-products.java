class Solution {
    public int findValidSplit(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int p = 2; p * p <= num; p++) {
                if (num % p == 0) {
                    first.putIfAbsent(p, i);
                    last.put(p, i);
                    while (num % p == 0) {
                        num /= p;
                    }
                    
                }
            }
            if (num > 1) {
                        first.putIfAbsent(num, i);
                        last.put(num, i);
                    }
        }

        int[] maxreach = new int[n];

        for (int key : first.keySet()) {
            int l = first.get(key);
            int r = last.get(key);
            maxreach[l] = Math.max(maxreach[l], r);
        }

        int r = 0;

        for (int i = 0; i < n - 1; i++) {
            r = Math.max(r, maxreach[i]);
            if (i == r)
                return i;
        }
        return -1;
    }
}