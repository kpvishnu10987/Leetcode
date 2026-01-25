class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) return false;

        int[] sarr = new int[26];
        int[] tarr = new int[26];
        for(int i = 0 ; i<n ; i++){
            sarr[s.charAt(i)-'a']++;
            tarr[t.charAt(i)-'a']++;
        }

        for(int i = 0 ; i<26 ; i++){
            if(sarr[i] != tarr[i]) return false;
        }
        
        return true;
    }
}