class Solution {
    public boolean isValid(String s) {
	    Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == ')' || c == ']' || c == '}' ) {
                if(st.isEmpty()) return false;
                if(c != st.pop()) return false; 
            } 
            else if (c == '(') st.push(')');
            else if (c == '[') st.push(']');
            else if (c == '{') st.push('}');
            
        }
        if(st.isEmpty()) return true;
        else return false;  
        
        
    }
}