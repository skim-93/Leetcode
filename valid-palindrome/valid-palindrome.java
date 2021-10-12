class Solution {
    public boolean isPalindrome(String s) {
        
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){
            
            // ignore non chars
            if (!Character.isLetterOrDigit(s.charAt(left))){
                left++;
                continue;
            }
            
            if (!Character.isLetterOrDigit(s.charAt(right))){
                right--;
                continue;
            }
            // check
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            
            // inc and dec "pointer"
            left++;
            right--;
        }
        
        return true;
    }
}