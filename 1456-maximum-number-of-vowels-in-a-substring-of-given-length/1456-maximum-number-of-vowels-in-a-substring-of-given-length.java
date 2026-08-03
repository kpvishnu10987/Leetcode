class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();

        int len = 0;

        for(int i = 0 ; i<k ;i++){
            if(isVowel(s.charAt(i))) len++;
        }

        int ans = len;

        for(int i = k ; i<n ; i++){
            if(isVowel(s.charAt(i))) len++;
            if(isVowel(s.charAt(i-k))) len--;
            ans = Math.max(ans,len);
        }

        return ans;
    }
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}