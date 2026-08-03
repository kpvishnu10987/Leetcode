class Solution {
    public String gcdOfStrings(String s, String t) {
        if(!(s+t).equals(t+s)){
            return "";
        }
        return t.substring(0,gcd(s.length(),t.length()));
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