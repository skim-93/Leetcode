class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        
        while(end < s.length()) {
            if(!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                max = Math.max(set.size(), max);
                end++;
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }
        
        return max;
        
        
    }
}