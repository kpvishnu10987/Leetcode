class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;

        for(int i = 0 ; i<n ; i++){
            if(bs(matrix[i],target)){
                return true;
            }
        }
        return false;
    }
    private boolean bs(int[] mat,int target){
        int l = 0;
        int r = mat.length-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(mat[mid] == target){
                return true;
            }else if(mat[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return false;
    }
}