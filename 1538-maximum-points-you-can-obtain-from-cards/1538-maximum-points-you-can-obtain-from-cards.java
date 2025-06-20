class Solution {
    public int maxScore(int[] cp, int k) {
        int n = cp.length;
        int total = 0;
        int max = 0;
        for(int i = 0 ;i<k; i++ ){
            total += cp[i];
        }
        max = total;
        for(int i =0;i<k;i++){
            total -= cp[k-1-i];
            total += cp[n-1-i];
            max = Math.max(max,total);
        }
        
        return max;
    }
}