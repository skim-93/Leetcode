class Solution {
    public boolean exist(char[][] board, String word) {
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(checkWord(word, board, i, j, 0)) {
                        return true;
                    }
                }
            }
        } 
        return false;
    }
    
    public boolean checkWord(String word, char[][] board, int row, int col, int ind) {
        boolean checker = false;
        
        if( row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(ind)) {
            return false;
        }
        
        
        if(ind == word.length() - 1) {
            return true;
        }
        
        char temp = board[row][col];
        board[row][col] = ' ';
        
        checker = checkWord(word, board, row - 1, col, ind+1) || checkWord(word, board, row + 1, col, ind+1) ||
                 checkWord(word, board, row, col - 1, ind+1) ||  checkWord(word, board, row, col + 1, ind+1);
        
        board[row][col] = temp;
        return checker;
    }
    
}