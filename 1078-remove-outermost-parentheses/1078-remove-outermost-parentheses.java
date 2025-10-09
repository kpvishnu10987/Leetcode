class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0;
        int balance = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i<s.length() ; i++){
            char c = s.charAt(i);

            if(open == 0 && balance == 0 && c == '('){
                open = 1;
                continue;
            }else if(open == 1 && balance == 0 && c == ')'){
                open = 0;
                continue;
            }else{
                if(c == '('){
                    sb.append(c);
                    balance++;
                }else{
                    sb.append(c);
                    balance--;
                }
            }
        }

        return sb.toString();


        
    }
}