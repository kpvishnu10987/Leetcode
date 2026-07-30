class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] maxf = new int[26];

        int l = 0;
        
        int sub = 0;

        for(int r = 0 ; r< n ;r++){
            maxf[s.charAt(r)-'A']++;

            int max = get(maxf);

            while(l < r && (r-l+1)-max > k){
                char lc = s.charAt(l);
                maxf[lc-'A']--;
                l++;
                max = get(maxf);
            }
            sub = Math.max(sub,r-l+1);
        }
        return sub;
    }

    private int get(int[] maxf){
        int max = 0;
        for(int i = 0 ; i<maxf.length ; i++){
            max = Math.max(max,maxf[i]);
        }

        return max;
    }
}