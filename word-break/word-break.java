class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Map<String, Boolean> memo = new HashMap<>();
        helper(s, memo, wordDict);
        return helper(s, memo, wordDict);
    }
    
    private boolean helper(String s, Map<String, Boolean> memo, List<String> wordDict) {
        if (s.isEmpty()) return true;

        boolean composite = false;
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (!memo.containsKey(s.substring(word.length()))) {
                    memo.put(s.substring(word.length()), helper(s.substring(word.length()), memo, wordDict));
                }
                composite = composite || memo.get(s.substring(word.length()));
            }
        }
        return composite;
    }
}