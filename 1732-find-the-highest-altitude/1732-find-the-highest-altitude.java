class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;

        int alt = 0;
        int ans = 0;
        for(int g : gain){
            alt += g;
            ans = Math.max(alt,ans);
        }

        return ans;
    }
}