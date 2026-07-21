class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        int child = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        while(i < n && j < m){
            if(s[j] >= g[i]){
                i++;
                j++;
                child++;
            }else{
                j++;
            }
        }

        return child;
    }
}