class Solution {
    public long countStableSubarrays(int[] capacity) {
         long n = capacity.length, res = 0, pre = 0;
        Map<Long, Map<Long, Long>> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mpp.containsKey((long)capacity[i])) {
                Map<Long, Long> t = mpp.get((long)capacity[i]);
                Long cnt = t.get(pre - capacity[i]);
                if (cnt != null) res += cnt;
            }
            pre += capacity[i];
            Map<Long, Long> t = mpp.computeIfAbsent((long)capacity[i], k -> new HashMap<>());
            t.put(pre, t.getOrDefault(pre, 0L) + 1L);
            if (i > 0 && capacity[i] == 0 && capacity[i - 1] == 0) res--;
        }
        return res;
    }
}