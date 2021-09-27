class Solution {
    public boolean exist(char[][] board, String word) {  

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0))
                if(checkWord(i,j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }    
    
    private boolean checkWord(int i, int j, char[][] board, String word, int index) {
            
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || index >= word.length() || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        if(index == word.length() -1) return true;
        
        char t = board[i][j];
        board[i][j] = ' ';
        
        boolean checker = false;
        checker = checkWord(i, j-1, board, word, index + 1) || checkWord(i, j+1, board, word, index + 1) ||
            checkWord(i+1, j, board, word, index + 1) || checkWord(i-1, j, board, word, index + 1);
        
        
        board[i][j] = t;
        
        
        
        return checker;
    }
}