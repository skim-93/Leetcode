class Solution {
    
    String alpha[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> list = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return list;
        }
        dfs(new char[digits.length()], 0, digits);
        return list;
    }
    
    public void dfs(char[] select, int index, String digits){
        if(index == digits.length()){
            StringBuilder s = new StringBuilder();
            for (char c : select) {
                s.append(c);
            }
            list.add(s.toString());
            return;
        }
        int charIndex = Character.getNumericValue(digits.charAt(index));
        for (int i = 0; i < alpha[charIndex].length(); i++) {
            select[index] = alpha[charIndex].charAt(i);
            dfs(select, index+1, digits);
        }
    }
}