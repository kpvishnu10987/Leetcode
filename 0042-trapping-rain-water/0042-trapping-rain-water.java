class Solution {
    public int trap(int[] arr) {
        int n = arr.length;

        int[] nge = new int[n];
        nge[n-1] = 0;

        int max = arr[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            max = Math.max(max,arr[i]);
            nge[i] = max;
        }

        int pre = 0;
        int water = 0;

        for(int i  = 0 ; i<n ; i++){
            int h = Math.min(pre,nge[i]);
            int cur = Math.max(0,h-arr[i]);
            water += cur;
            pre = Math.max(pre,arr[i]);
        }

        System.out.print(Arrays.toString(nge));

        return water;
    }
}