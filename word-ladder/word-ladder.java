class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //first we will add all the word in the list for us to use it for BFS search
        
        Set<String> set = new HashSet<>();
        for(String word : wordList) {
            set.add(word);
        }
        
        //if the set does not contains endWord, we return 0
        if(!set.contains(endWord)) {
            return 0;
        }
        
        //for bfs we will be using the queue, to go through each word
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        
        while(!q.isEmpty()) {
            int currentSize = q.size();
            
            //we will iterate through the current level of the queue, then add all of the 'oneaway' to the queue, and remove it from set to that we do not use it again
            for(int i = 0; i < currentSize; i++) {
                //we need to do it for every word within the level, so poll it
                String currentWord = q.poll();
                char[] charWord = currentWord.toCharArray();
                
                for(int j = 0; j < charWord.length; j++) {
                    char originchar = charWord[j];
                    
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(charWord[j] == c) continue;
                        charWord[j] = c;
                        
                        String newWord = String.valueOf(charWord);
                        if(newWord.equals(endWord)) return level + 1;
                        
                        if(set.contains(newWord)) {
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    charWord[j] = originchar;
                    
                }
                
                
            }
            
            //after the each level, we up level by 1;
            level++;
            
            
        }
        
        
        
        return 0;
        
    
    }
}