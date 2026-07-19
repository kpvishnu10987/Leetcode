class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n == 1) return s;

        long k = n/2;

        return 1L*s +  k * m - k +1;
    }
}