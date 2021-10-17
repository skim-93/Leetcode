class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap();
        return dfs(s, wordDict, map);
    }
    
    public boolean dfs(String s, List<String> wordDict, Map<String, Boolean> map) {
        if(s.length() == 0) {
            return true;
        }
        
        boolean checker = false;
        
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                String suffix = s.substring(word.length());
                if(!map.containsKey(suffix)) {
                    map.put(suffix, dfs(suffix, wordDict, map));
                }
                checker = checker || map.get(suffix);
            }
        }
        
        return checker;
    }
    
}