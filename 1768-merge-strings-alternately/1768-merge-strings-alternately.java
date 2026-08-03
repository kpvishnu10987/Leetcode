class Solution {
    public String mergeAlternately(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();

        while(i<n && j < m){
            sb.append(s.charAt(i++));
            sb.append(t.charAt(j++));
        }

        while(i < n){
            sb.append(s.charAt(i++));
        }

        while(j < m){
            sb.append(t.charAt(j++));
        }

        return sb.toString();
    }
}