class Solution {
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
                
            }
        }
                    
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int row, int column, int ind) {
        if(row < 0 || column <0 || row >=board.length || column >= board[row].length || ind >= word.length() || board[row][column] != word.charAt(ind)) {
            return false;
        }
        
        if(ind == word.length()-1) return true;
        
        char t= board[row][column];
        board[row][column] = ' ';
        
        boolean checker = false;
        checker = dfs(board, word, row - 1, column, ind + 1) || dfs(board, word, row, column - 1 , ind + 1) ||
                    dfs(board, word, row + 1, column, ind + 1) || dfs(board, word, row, column + 1, ind + 1);
        board[row][column] = t;
        
        return checker;
    }    
}