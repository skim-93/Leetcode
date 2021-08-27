import java.math.BigInteger;

class Solution {
    public int myAtoi(String s) {
        long res = 0;
        int isNeg = 1;
        boolean start = false;
        
        for(char c : s.toCharArray()) {
            if(c == ' ') {
                if(start) {
                    break;
                }
                continue;
            }
            
            if(!((c>='0'&& c<='9') || (c == '-' && !start) || (c == '+' && !start))) {
                 break;
            }
                  
            if(c=='-'){
                isNeg = -1;
                start = true;
                continue;
            }else if(c=='+'){
                start = true;
                continue;
            }
            start = true;
            res= res*10+ (c-'0');
            if(isNeg*res>=Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(isNeg*res<=Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return isNeg*(int)res;
    }
}