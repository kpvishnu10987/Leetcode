class Solution {
    private boolean isMatchhing(char open,char close){
        if(open == '(' && close == ')') return true;
        if(open == '{' && close == '}') return true;
        if(open == '[' && close == ']') return true;
        return false;
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        if(n == 0) return true;
        for(int i  = 0; i<n ;i++){
            char item = s.charAt(i);
            if(item == '(' || item == '{' || item == '['){
                st.push(item);
            }else if(!st.isEmpty() && isMatchhing(st.peek(),item)){
                st.pop();
            }else{
                return false;
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}