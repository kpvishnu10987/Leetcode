class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int left = 0;
        int right = 0;
        int maxfreq = 0;
        int ans = 0;


        for(right = 0 ; right < s.length() ; right++){
            char c = s.charAt(right);
            freq[c-'A']++;
            maxfreq = Math.max(maxfreq,freq[c-'A']);

            while((right-left+1)-maxfreq >k){
                char r = s.charAt(left);
                freq[r-'A']--;
                left++;
            }

            ans = Math.max(ans,right-left+1);
        }


        return ans;
        
    }
}