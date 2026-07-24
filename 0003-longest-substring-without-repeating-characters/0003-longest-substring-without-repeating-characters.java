class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int l = 0;
        int max = 0;
        for(int r = 0 ; r<n ; r++){
            char rc = s.charAt(r);

            while(set.contains(rc)){
                char lc = s.charAt(l);
                set.remove(lc);
                l++;
            }
            set.add(rc);
            max = Math.max(max,r-l+1);
        }

        return max;
    }
}