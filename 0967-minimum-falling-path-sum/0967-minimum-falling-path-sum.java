class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = m-2 ; i>=0 ; i--){
            for(int j = 0; j<n ; j++){
                int bl = Integer.MAX_VALUE;
                int br = Integer.MAX_VALUE;
                if(j > 0){
                    bl = matrix[i+1][j-1];
                }
                if(j < n-1){
                    br = matrix[i+1][j+1];
                }
                int down = matrix[i+1][j];
                matrix[i][j] += Math.min(down,Math.min(bl,br));
            }
        }
        return Arrays.stream(matrix[0]).min().getAsInt();
        
    }
}