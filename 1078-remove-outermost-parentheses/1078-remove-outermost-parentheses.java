class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder output = new StringBuilder();
        int open = 0;
        for(char c : s.toCharArray()){
            
            if (c == '(' && open++ > 0) output.append(c);
            if (c == ')' && open-- > 1) output.append(c);
        }
        return output.toString();
    }
}