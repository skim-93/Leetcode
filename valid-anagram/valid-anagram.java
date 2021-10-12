class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        for(char c1 : s.toCharArray()) {
            if(map.containsKey(c1)) {
                map.put(c1, map.get(c1) + 1);
            } else {
                map.put(c1, 1);
            }
        }
        
        for(char c2 : t.toCharArray()) {
            if(map.containsKey(c2)) {
                if(map.get(c2) == 1) {
                    map.remove(c2);
                } else {
                    map.put(c2, map.get(c2) - 1);
                }
            } else {
                return false;
            }
        }
        
        if(map.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}