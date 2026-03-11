class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        Set<Character> set = new HashSet<>();
        int len = 0;
        for(int r = 0; r<n ; r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            len = Math.max(len,r-l+1);
        } 

        return len;
        
    }
}