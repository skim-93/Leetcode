class Solution {
      public List<String> wordBreak(String s, List<String> wordDict) 
    {        
        Set<String> dict = new HashSet();
        for (String word : wordDict)
        {
            dict.add(word);
        }
        
        List<String> result = new ArrayList();
        dfs(s, 0, dict, null, result);
        return result;
    }
    
    void dfs(String s, int pos, Set<String> dict, String curr, List<String> result)
    {
        if (pos == s.length())
        {
            result.add(curr);
            return;
        }
        
        for (int i = pos; i < s.length(); ++i) {
            String prefix = s.substring(pos, i + 1);
            if (dict.contains(prefix)) {
                dfs(s, i + 1, dict, curr == null ? prefix : curr + " " + prefix, result);
            }
        }
    }
    
}