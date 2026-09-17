class Solution {
    public int hammingWeight(int n) {
        int c =0;
        int i = 0;
        while(n >> i > 0){
            c += (n >> i & 1);
            i++;
        }
        return c;
    }
}