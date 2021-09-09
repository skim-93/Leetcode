class Solution {
    public int minPathSum(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[row][col];
        
        res[0][0] = grid[0][0];
        
        //get first row addition
        for(int i = 1; i < col; i++) {
            res[0][i] = grid[0][i] + res[0][i-1];
        }
        
        // get first colum addition
        for(int j = 1; j < row; j++) {
            res[j][0] = grid[j][0] + res[j-1][0];
        }
        
        
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                res[i][j] = grid[i][j] + Math.min(res[i-1][j], res[i][j-1]);
            }
        }
        
        return res[row-1][col-1];
    }
}