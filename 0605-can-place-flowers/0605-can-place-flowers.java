class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int m = arr.length;
        if(n == 0) return true;

        if(n == 1 && m == 1) return arr[0] == 0;


        

        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i] == 1) continue;
            if(i-1 >= 0 && i+1 <m && arr[i-1] != 1 && arr[i+1] != 1){
                n--;
                arr[i] = 1;
            }else if(i == 0 && i+1 < m && arr[i+1] != 1){
                n--;
                arr[i] = 1;
            }else if(i+1 == m && arr[i-1] != 1){
                n--;
                arr[i] = 1;
            }
            if(n == 0) return true;
        }

        return n == 0;
    }
}