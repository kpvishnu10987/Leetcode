class Solution {
    public String mergeAlternately(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while(i < n || i < m){
            if(i < n){
                sb.append(s.charAt(i));
            }

            if(i < m){
                sb.append(t.charAt(i));
            }

            i++;
        }

        return sb.toString();
    }
}