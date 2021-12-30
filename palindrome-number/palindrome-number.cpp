class Solution {
public:
    bool isPalindrome(int x) {
        
        if(x<0) return false;
        int copy = x, rx = 0;
        while(x>0){
            int d = x%10;
            x/=10;
            if(rx>(INT_MAX-d)/10) return false;
            rx = rx*10 + d;
        }
        return copy == rx;
        
    }
};