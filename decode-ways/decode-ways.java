class Solution {
    public int numDecodings(String s) {
    if (s == null || s.isEmpty()) 
    	return 0;
    if (s.charAt(0) == '0')
    	return 0;
    int[] f = new int[s.length() + 1];
    f[0] = 1; f[1] = 1;
    for (int i = 1; i < s.length(); i++) {
    	if (s.charAt(i) == '0') {    //'0'
    		if (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0')
    			return 0; //invalid string
    		else {
    			f[i+1] = f[i - 1];
    		}
    	} else if (s.charAt(i) > '0' && s.charAt(i) < '7') {  //'1' - '6'
    		if (s.charAt(i-1) > '0' && s.charAt(i-1) < '3') {
    			f[i+1] = f[i] + f[i-1];
    		} else 
    			f[i+1] = f[i];
    	} else {   //'7' - '9'
    		if (s.charAt(i-1) == '1') 
    			f[i+1] = f[i] + f[i-1];
    		else 
    			f[i+1] = f[i];
    	}
    }
    return f[s.length()];
    }
}