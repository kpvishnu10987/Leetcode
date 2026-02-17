class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for(int i = 0 ; i<9 ; i++){
            for(int j = 0 ; j<9 ; j++){
                char val = board[i][j];

                if(val == '.') continue;

                String rowkey = "row"+i+"-"+val;
                String colkey = "col"+j+"-"+val;
                String boxkey = "Box"+(i/3)+"-"+(j/3)+"-"+val;
                if(!seen.add(rowkey)||
                    !seen.add(colkey)||
                    !seen.add(boxkey)){
                        return false;
                    }
            }
        }
        return true;

    }
}