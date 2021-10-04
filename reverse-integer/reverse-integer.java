class Solution {
    public int reverse(int x) {
        int res = 0;
        while(Math.abs(x) > 0) {
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && x%10 > 7)) return 0;
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && x%10 < -8)) return 0;
            res = res* 10 + x % 10;
            x = x/10;
            
            
        }
        
        return res;
    }
}