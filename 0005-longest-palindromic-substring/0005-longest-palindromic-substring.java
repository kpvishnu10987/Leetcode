class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0) return new String();
        if(n == 1) return s;
        for(int size = n ; size > 1 ; size--){
            for(int start = 0 ; start <= n-size ; start++){
                if(isPalin(s.substring(start,start+size))){
                    return s.substring(start,start+size);
                }
            }
        }
        
        return s.substring(0,1);
    }

    private boolean isPalin(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}