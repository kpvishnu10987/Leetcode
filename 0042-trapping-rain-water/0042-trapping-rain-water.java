class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int lmax = 0;
        int rmax = 0;

        int l = 0;
        int r = n-1;
        int water = 0;

        while(l < r){
            if(arr[l] <= arr[r]){
                if(arr[l] > lmax){
                    lmax = arr[l];
                }else{
                    water += lmax-arr[l];
                }
                l++;
            }else{
                if(arr[r] > rmax){
                    rmax = arr[r];
                }else{
                    water += rmax-arr[r];
                }
                r--;
            }
        }

        return water;
        
        
    }
}