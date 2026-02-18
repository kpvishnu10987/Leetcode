class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;

        Stack<Integer> st = new Stack<>();

        for(int i = 0 ;i< n ; i++){
            String s = tokens[i];
            if(isOperator(s)){
                int a = st.pop();
                int b = st.pop();
                int result = helper(b,a,s);
                st.push(result);
            }else{
                st.push(Integer.parseInt(s));
            }
        }

        return st.pop();
        
    }
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") ||
               s.equals("*") || s.equals("/");
    }


    private int helper(int a,int b,String c){
        int op1 = a;
        int op2 = b;
        if(c.equals("*")){
            return op1 * op2;
        }else if(c.equals("+")){
            return op1 + op2;
        }else if(c.equals("-")){
            return op1-op2;
        }else{
            return op1/op2;
        }
    }
}