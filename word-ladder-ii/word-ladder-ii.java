class Solution {
    
    int minPathLength = Integer.MAX_VALUE;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        
        Set<String> set = new HashSet<>(wordList);
        
        if(!set.contains(endWord)) {
            return res;
        }
        
        Set<String> visited = new HashSet<String>();
        List<String> currPath = new ArrayList<>();
        currPath.add(beginWord);
        
        Map<String, Integer> distanceTracker = new HashMap<>();
        bfs(beginWord, endWord, set, distanceTracker);
        dfs(beginWord, endWord, set, visited, currPath, res, distanceTracker);
        
        return res;   
    }
    
    private void bfs(String beginWord, String endWord, Set<String> set, Map<String, Integer> distanceTracker) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        distanceTracker.put(beginWord, 1);
        
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                String curr = q.poll();
                
                for(String str: getNextWord(curr, set)) {
                    if(!distanceTracker.containsKey(str)) {
                        distanceTracker.put(str, level);
                        if(str.equals(endWord)) {
                            continue;
                        }
                        q.offer(str);
                    }
                }
            }
        }
    }
    
    private void dfs(String beginWord, String endWord, Set<String> set, Set<String> visited, List<String> currPath, List<List<String>> res, Map<String, Integer> distanceTracker) {
        if(currPath.size() > distanceTracker.get(beginWord)) return;
        
        if(currPath.size() > minPathLength) return;
        
        if(beginWord.equals(endWord)) {
            if(currPath.size() == minPathLength) {
                res.add(new ArrayList(currPath));
            }
            else if(currPath.size() < minPathLength) {
                minPathLength = currPath.size();
                res.clear();
                res.add(new ArrayList(currPath));
            }
            return;
        }
        
        for(String word: getNextWord(beginWord, set)) {
            if(visited.contains(word)) continue;
            visited.add(word);
            currPath.add(word);
            dfs(word, endWord, set, visited, currPath, res, distanceTracker);
            currPath.remove(currPath.size() - 1);
            visited.remove(word);
        }
        
        
    }
    
    
    private List<String> getNextWord(String word, Set<String> set) {
        List<String> list = new ArrayList<String>();
        
        for(int i = 0; i < word.length(); i++) {
            for(char c = 'a'; c <= 'z'; c++) {
                if(word.charAt(i) == c) continue;
                
                char[] charArr = word.toCharArray();
                charArr[i] = c;
                String newWord = new String(charArr);
                
                if(set.contains(newWord)) {
                    list.add(newWord);
                }
            }
        }
        return list;
    }
    
    
}