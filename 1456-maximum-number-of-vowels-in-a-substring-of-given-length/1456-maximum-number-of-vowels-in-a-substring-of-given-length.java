class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        Set<Character> oval = Set.of('a','e','i','o','u');

        int len = 0;

        for(int i = 0 ; i<k ;i++){
            if(oval.contains(s.charAt(i))) len++;
        }

        int ans = len;

        for(int i = k ; i<n ; i++){
            if(oval.contains(s.charAt(i))) len++;
            if(oval.contains(s.charAt(i-k))) len--;
            ans = Math.max(ans,len);
        }

        return ans;
    }
}