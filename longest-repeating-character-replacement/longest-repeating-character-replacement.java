class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int max = 0;
        
        for(int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            
            while(right - left + 1 - getMaxCount(count) > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            } 
            
            max = Math.max(max, right - left + 1);
        }
        
        
        return max;
    }
    
    
    
    public int getMaxCount(int[] count) {
        int max = 0;
        
        for(int i : count) {
            max = Math.max(i, max);
        }
        return max;
    }
}