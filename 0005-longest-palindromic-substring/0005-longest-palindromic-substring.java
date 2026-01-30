class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;

        String ans = new String();
        int maxlen = Integer.MIN_VALUE;
        int len = 0;

        for(int i = 0 ; i<n ; i++){
            for(int j = i+1; j <=n ; j++){
                String sub = s.substring(i,j);
                if(isPal(sub)){
                    len = sub.length();
                    if(len > maxlen){
                        maxlen = len;
                        ans = sub;
                    }
                }
            }
        }

        return ans;
        
    }
    private boolean isPal(String t){
        int m = t.length();

        for(int i = 0  ; i<m/2 ; i++){
            if(t.charAt(i) != t.charAt(m-i-1)) return false;
        }

        return true;
    }
}