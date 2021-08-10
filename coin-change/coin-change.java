class Solution {
    public int coinChange(int[] coins, int amount) {
        //this would give our ceiling of the amount 
        int max = amount + 1;
        
        //create an int array with number of ceiling amount 
        int[] dp = new int[max];
        //then we fill the array with number of the max
        Arrays.fill(dp, max);
        
        //because we go bottom top, when amount is 0 we know it will be 0 coin to fill
        dp[0] = 0;
        
        //for loop to go from 1 to amount
        for(int i = 1; i <= amount; i++) {
            
            // inner for loop that goes to how many of coins
            for(int j = 0; j < coins.length; j++) {
                
                //if coin at j is smaller or equal to the amount we are looking at which is i
                if(coins[j] <= i) {
                    //we find out how many coins that can go in there with minimum amount.
                    // for example, let say we have list of coins [1,2,3] then amount is 5
                    // at amount 1, it will choose between 6 and (1-1) +1 = 1
                    // then go to amount 2, it wiil choocse between 6 and dp[2-1] + 1 which is 2
                    // then check with 2 and dp[2-2] + 1, which is 1 etc...
                    
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        
        //after forloops, it will check last column is bigger then the amount, if it is then we cannot find the right coin
        if(dp[amount] > amount) {
           return -1; 
        } else {
            // else we return the amount we found
            return dp[amount];
        }
    }
    
}