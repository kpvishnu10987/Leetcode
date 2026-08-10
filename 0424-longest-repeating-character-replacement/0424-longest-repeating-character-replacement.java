class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int[] freq = new int[26];
        int l = 0;
        int maxf = 0;
        int ans = 0;

        for(int r = 0 ; r<n ; r++){
            char rc = s.charAt(r);
            freq[rc-'A']++;

            maxf = Math.max(maxf,freq[rc-'A']);

            while(r-l+1 - maxf > k){
                char lc = s.charAt(l);
                freq[lc-'A']--;

                for(int x : freq){
                    maxf = Math.max(maxf,x);
                }
                l++;
            }

            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}