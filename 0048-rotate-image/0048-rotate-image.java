class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i<n ; i++){
            for(int j = i+1 ; j<m ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i = 0; i<n ; i++){
            int first = 0;
            int last = m-1;
            while(first < last){
                int temp = matrix[i][first];
                matrix[i][first] = matrix[i][last];
                matrix[i][last] = temp;
                first++;
                last--;
            }
        }
    }
}