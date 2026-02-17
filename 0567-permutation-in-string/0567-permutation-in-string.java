class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for(char c : s1.toCharArray()){
            need[c-'a']++;
        }

        for(int i = 0 ; i<m ; i++){
            window[s2.charAt(i)-'a']++;

            if(i >= n){
                window[s2.charAt(i-n)-'a']--;
            }

            if(match(need,window)) return true;
        }

        return false;

        
    }

    private boolean match(int[] a ,int[] b){
        for(int i = 0 ; i<26 ; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}