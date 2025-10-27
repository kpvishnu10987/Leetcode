class Solution {
    private boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length() ; i++){
            char c = s.charAt(i);
            if(c == ')'){
                if(st.isEmpty()){
                    return false;
                }else{
                    st.pop();
                }
            }else{
                st.push(c);
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String cur = "";
        helper(n,ans,cur);
        return ans;
    }
    private void helper(int n , List<String> ans,String cur){

        if(cur.length() == 2*n){
            if(isValid(cur)){
                ans.add(cur);
            }
            return;
        }
        helper(n,ans,cur+"(");
        helper(n,ans,cur+")");

    }
}