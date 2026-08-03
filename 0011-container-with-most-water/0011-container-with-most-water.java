class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;

        int l = 0;
        int r = n-1;
        int area = 0;


        while(l < r){
            int width = r - l;
            int h = Math.min(arr[l],arr[r]);

            area = Math.max(area,width * h);

            if(arr[l] > arr[r]){
                r--;
            }else{
                l++;
            }
        }

        return area;
    }
}