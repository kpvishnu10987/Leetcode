class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] targetFreq = new int[128];
        for (char c : t.toCharArray()) targetFreq[c]++;

        int left = 0, right = 0, start = 0, minLen = Integer.MAX_VALUE;
        int count = t.length();

        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (targetFreq[rChar] > 0) count--;
            targetFreq[rChar]--;
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lChar = s.charAt(left);
                targetFreq[lChar]++;
                if (targetFreq[lChar] > 0) count++;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
