class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String cur = "";
        helper(n,ans,0,0,cur);
        return ans;
    }
    private void helper(int n , List<String> ans,int open ,int close,String cur){

        if(cur.length() == 2*n){
            
                ans.add(cur);
            
            return;
        }
        if(open < n){
            helper(n,ans,open+1,close,cur+"(");
        }
        if(close < open){
            helper(n,ans,open,close+1,cur+")");
        }

    }
}