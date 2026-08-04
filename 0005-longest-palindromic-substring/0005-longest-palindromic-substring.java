class Solution {
    int start = 0;
    int maxlen = 1;
    public String longestPalindrome(String s) {
        for(int i = 0 ; i<s.length() ; i++){
            expand(s,i,i);
            expand(s,i,i+1);
        }

        return s.substring(start,start+maxlen);
    }

    private void expand(String s,int l,int r){
        while(l >= 0 && r < s.length() &&  s.charAt(l) == s.charAt(r)){
            if(r-l + 1 > maxlen){
                maxlen = r-l+1;
                start = l;
            }

            l--;
            r++;
        }
    }
}