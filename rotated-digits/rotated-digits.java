class Solution {
    public int rotatedDigits(int n) {
        int[] dp = new int[n+1];
        int res = 0;
        Set<Integer> s1 = Set.of(0,1,8), s2 = Set.of(2,5,6,9);
        for(int i = 0 ; i < Math.min(10, n + 1); i++) {
            if(s1.contains(i)) dp[i] = 1;
            else if(s2.contains(i)) {
                dp[i] = 2;
                res++;
            }
        }
        
        for(int i = 10; i <= n; i++) {
            int a = dp[i/10], b = dp[i % 10];
            if(a == 1 && b == 1) dp[i] = 1;
            else if(a >= 1 && b >= 1) {
                dp[i] = 2;
                res++;
            }
        }
        
        
        
        return res;
    }
}


// 0, 1, 8 rotate themselves
// 2, 5 rotate each other
// 6, 9 rotate each other





