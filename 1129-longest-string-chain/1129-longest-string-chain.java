class Solution {
    private static boolean isp(String s, String s1) {
        if (s.length() != s1.length()+1){
            return false;
        }
        int first = 0;
        int second = 0;

        while (first < s.length()){
            if (second < s1.length() && s.charAt(first) == s1.charAt(second)){
                first++;
                second++;
            }
            else {
                first++;
            }
        }
        if (first == s.length() && second == s1.length()){
            return true;
        }
        else return false;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,Comparator.comparingInt(String::length));
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);

        for(int i = 0; i<n ; i++){
            for(int j = 0; j<i ; j++){
                if(isp(words[i],words[j]) && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = 0;
        for(int i = 0 ; i<n ; i++){
            max = Math.max(dp[i],max);
        }
        return max;

        
    }
}