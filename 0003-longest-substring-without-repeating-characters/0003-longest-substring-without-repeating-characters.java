class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int max = 0;

        Set<Character> set = new HashSet<>();
        int l = 0;

        for(int i = 0 ; i<n ; i++){
            char rc = s.charAt(i);

            while(set.contains(rc)){
                char lc = s.charAt(l);
                set.remove(lc);
                l++;
            }
            set.add(rc);
            max = Math.max(max,i-l+1);
        }

        return max;
    }
}