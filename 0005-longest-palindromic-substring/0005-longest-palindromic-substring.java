class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int maxlen = Integer.MIN_VALUE;

        String ans = new String();
        int start = 0;

        for(int i = 0 ; i<n ;i++){
            int l = i;
            int r = i;

            while(l >=0 && r <=n-1 && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxlen){
                    maxlen = r-l+1;
                    start = l;
                    
                }
                l--;
                    r++;
            }

            l = i;
            r = i+1;

            while(l >=0 && r <=n-1 && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > maxlen){
                    maxlen = r-l+1;
                    start = l;
                    
                }
                l--;
                    r++;
            }

        }
        
        return s.substring(start,start+maxlen);
        
    }
}