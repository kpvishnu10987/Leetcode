class Solution {
    public int numberOfArrays(int[] arr, int lower, int upper) {
        int n = arr.length;

        long x = lower;
        long min = lower;
        long max = lower;

        for(int i = 0 ; i<n ; i++){
            x += arr[i];
            min = Math.min(min,x);
            max = Math.max(max,x);
        }

        long ans =(long)(upper-lower+1) - (max-min);

        return ans > 0 ? (int)ans : 0;
    }
}