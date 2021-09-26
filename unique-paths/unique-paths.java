class Solution {

    
    public int uniquePaths(int m, int n) {
        
        int[][] arr = new int[m+1][n+1];
        arr[m][n] = paths(m,n, arr);
        
        return arr[m][n];
    }
    
    public int paths(int m, int n, int[][] arr) {
        if(m == 1 || n == 1) return 1;
        
        if(arr[m-1][n] == 0){
            arr[m-1][n] = paths(m-1, n, arr);
        }
        
        if(arr[m][n-1] == 0) {
            arr[m][n-1] = paths(m,n-1, arr);
        }
        
        return arr[m-1][n] + arr[m][n-1];
    }
    
}