class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sS = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c != '#') {
                sS.push(c);
            } else if(!sS.isEmpty()) {
                if(c == '#') {
                    sS.pop();
                }
            }
        }
    
        Stack<Character> tS = new Stack<>();
        for(char c: t.toCharArray()) {
            if(c != '#') {
                tS.push(c);
            } else if(!tS.isEmpty()) {
                if(c == '#') {
                    tS.pop();
                }
            }
        }
        
        while(!sS.isEmpty()) {
            char c = sS.pop();
            if(tS.isEmpty() || tS.pop() != c) {
                return false;
            }
        }
        
        
        return sS.isEmpty() && tS.isEmpty();
    }
}