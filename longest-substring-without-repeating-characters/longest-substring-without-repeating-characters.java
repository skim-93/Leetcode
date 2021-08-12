class Solution {
    public int lengthOfLongestSubstring(String s) {
        //brute force solution
        int maxCount = 0;
        int count = 0;
        
        if(s.length() == 1) return 1;
        
        Set<Character> set = new HashSet<Character>();
        
        for(int i = 0; i < s.length()-1; i++) {
            set.clear();
            set.add(s.charAt(i));
            count = 1;
            for(int j = i+1; j < s.length(); j++) {
                if(!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    count++;
                    maxCount = Math.max(maxCount, count);
                } else {
                    maxCount = Math.max(maxCount, count);
                    break;
                }
            }
        }
        return maxCount;
    }
}