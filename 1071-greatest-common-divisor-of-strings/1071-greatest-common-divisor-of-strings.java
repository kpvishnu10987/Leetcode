class Solution {
    public String gcdOfStrings(String s, String t) {
        int n = s.length();
        int m = t.length();
        int len = gcd(n,m);

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int i = 0,j = 0;

        while(i+len <= n){
            set1.add(s.substring(i,i+len));
            i = i+len;
        }

        while(j+len <= m){
            set2.add(t.substring(j,j+len));
            j = j+len;
        }

        if(set1.size() != 1 || set2.size() != 1 || !set1.equals(set2)) return "";



        if(len < n){
            return s.substring(0,len);
        }
        return t.substring(0,len);
    }

    private int gcd(int a,int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}