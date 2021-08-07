class Solution {
    public int maxProfit(int[] prices) {
        //Initial thought was to find bigest profit front to back, then store those Max profit as bruteforce
        /*
        int maxPro = 0;
        
        for(int i = 0; i < prices.length-1; i++) {
            for(int j = i+1; j < prices.length; j++) {
                maxPro = Math.max(maxPro, prices[j] - prices[i]);
            }
        }
        */
        //Time Complexity: O(n^2)
        //Space Complexity: O(1)
        //I got time out error when using this method, which I need optimized solution
        
        //noticed that we only need to change min number when new min number comes out, and when new max number is          out else we do not need to do anything to maxPro
        
        //optimized solution - using local variable min and max
        
        int maxPro = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            } else if(prices[i] - min > maxPro) {
                maxPro = prices[i] - min;
            }
            
        }
        //Time Complexity O(n)
        //Space Complexity O(1)
        
        return maxPro;
    }
}