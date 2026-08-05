class Solution {
    public int trap(int[] arr) {
        int n = arr.length;

        int[] rmax = new int[n];
        rmax[n-1] = 0;

        for(int i = n-2 ; i>=0 ; i--){
            rmax[i] = Math.max(rmax[i+1],arr[i+1]);
        } 

        int lmax = 0;
        int water = 0;

        for(int i = 0 ; i<n ; i++){
            int h = Math.min(lmax,rmax[i]);
            water += Math.max(0,h-arr[i]);
            lmax = Math.max(lmax,arr[i]);
        }

        return water;
    }
}