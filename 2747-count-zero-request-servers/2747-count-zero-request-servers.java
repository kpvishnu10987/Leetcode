class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // 1. Sort logs by time
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        // 2. Sort query indices by query value (keep original index to place answer back)
        Integer[] qIdx = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) qIdx[i] = i;
        Arrays.sort(qIdx, (a, b) -> queries[a] - queries[b]);

        int[] ans = new int[queries.length];
        Map<Integer, Integer> freq = new HashMap<>();
        int active = 0;
        int left = 0, right = 0;

        for (int idx : qIdx) {
            int q = queries[idx];

            // Expand window: include logs with time <= q
            while (right < logs.length && logs[right][1] <= q) {
                int sid = logs[right][0];
                int c = freq.getOrDefault(sid, 0);
                freq.put(sid, c + 1);
                if (c == 0) active++;
                right++;
            }

            // Shrink window: remove logs with time < q - x
            while (left < right && logs[left][1] < q - x) {
                int sid = logs[left][0];
                int c = freq.get(sid) - 1;
                freq.put(sid, c);
                if (c == 0) active--;
                left++;
            }

            ans[idx] = n - active;
        }

        return ans;
    }
}