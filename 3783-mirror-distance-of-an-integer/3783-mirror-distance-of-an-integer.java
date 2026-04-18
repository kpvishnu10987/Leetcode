class Solution {
    public int mirrorDistance(int n) {
        int temp = n;
        int rev = 0;
        while(n != 0){
            int l = n%10;
            rev = rev*10+l;
            n /= 10;
        }
        int result = temp-rev;
        return Math.abs(result);
        
    }
}