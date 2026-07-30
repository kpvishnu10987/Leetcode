class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for(char c  : s1.toCharArray()){
            need[c-'a']++;
        }
        int l = 0;

        for(int r = 0 ;  r<m ;r++){
            window[s2.charAt(r)-'a']++;

            if(r-l+1 > n){
                window[s2.charAt(l)-'a']--;
                l++;
            }

            if(Arrays.equals(need,window)) return true;
        }
        return false;
    }
}