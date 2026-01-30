class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for(int i = 0 ; i <n ; i++){
            count += expand(s,i,i);
            count += expand(s,i,i+1);
        }

        return count;
    }

    private int expand(String s ,int i, int j){
        int cnt = 0;
        int n = s.length();

        while(i >= 0 && j<n && s.charAt(i) == s.charAt(j)){
            cnt++;
            i--;
            j++;
        }

        return cnt;

    }
}