class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        for(int[] arr : matrix){
            if(bs(arr,target)){
                return true;
            }
        }
        return false;
    }
    private boolean bs(int[] arr,int target){
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int num = arr[mid];
            if(num == target){
                return true;
            }else if(num >  target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return false;

    }
}