class Solution {
    public void reverseString(char[] s) {
        char[] reverse = new char[s.length];
        int j = 0;
        
        for(int i = s.length - 1; i >= 0; i--) {
            reverse[j] = s[i];
            j++;
        }
        
        j = 0;
        for(char c : reverse) {
            s[j] = c;
            j++;
        }
        
    }
}