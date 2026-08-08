class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] lmax = new int[n];

        int prev = 0;

        lmax[n-1] = 0;
        for(int i = n-2 ; i>=0 ; i--){
            lmax[i] = Math.max(arr[i+1],lmax[i+1]);
        }

        int water = 0;
        for(int i = 0 ; i< n; i++){
            int h = Math.min(lmax[i],prev);
            water += Math.max(0,h-arr[i]);
            prev = Math.max(prev,arr[i]);
        }

        return water;
    }
}