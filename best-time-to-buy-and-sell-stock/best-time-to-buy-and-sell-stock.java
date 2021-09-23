class Solution {
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int max = 0;
        
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minValue) {
                minValue = prices[i];
            }
            
            else if(max < prices[i] - minValue) {
                max = prices[i] - minValue;
            }
        }
        
        return max;
    }
}