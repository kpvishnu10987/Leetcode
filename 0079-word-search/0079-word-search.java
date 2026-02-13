class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(i, j, 0, vis, board, word)) return true;
                }
            }
        }
        return false;
    }

    private boolean helper(int r, int c, int index, boolean[][] vis, char[][] board, String word) {
        if (index == word.length()) return true;

        
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || 
            vis[r][c] || board[r][c] != word.charAt(index)) {
            return false;
        }

        vis[r][c] = true; 

       
        boolean found = helper(r + 1, c, index + 1, vis, board, word) ||
                        helper(r - 1, c, index + 1, vis, board, word) ||
                        helper(r, c + 1, index + 1, vis, board, word) ||
                        helper(r, c - 1, index + 1, vis, board, word);

        vis[r][c] = false; 

        return found;
    }
}