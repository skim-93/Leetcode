class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int b1 = Integer.MIN_VALUE;
        int s1 = 0;
        int b2 = Integer.MIN_VALUE;
        int s2 = 0;
        
        for(int i=0;i<prices.length;i++) {
            
            b1 = Math.max( b1, -prices[i]);
            s1 = Math.max( s1, b1 + prices[i]);
            b2 = Math.max( b2, s1 - prices[i]);
            s2 = Math.max( s2, b2 + prices[i]);
        }
        
        return Math.max(0, s2);
    }
}