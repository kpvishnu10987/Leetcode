class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int pr = dig(n);
            if(pr % t == 0) return n;
            n++;
        }
    }
    private int dig(int n){
        int pr = 1;
        while(n > 0){
            pr *= n % 10;
            n /= 10;
        }
        return pr;
    }
}