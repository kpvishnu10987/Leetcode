class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int l = 0;
        int maxf = 0;
        int[] freq = new int[26];
        int ans = 0;

        for(int r = 0 ; r<n ; r++){
            char c = s.charAt(r);
            freq[c-'A']++;
            maxf = Math.max(maxf,freq[c-'A']);

            while(r-l+1 - maxf > k){
                char lc = s.charAt(l);
                freq[lc-'A']--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}