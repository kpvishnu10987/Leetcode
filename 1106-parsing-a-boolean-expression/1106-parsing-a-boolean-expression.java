class Solution {
    public boolean parseBoolExpr(String s) {
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(c != ')'){
                st.push(c);
            }else{
                List<Character> list = new ArrayList<>();

                while(st.peek() != '('){
                    list.add(st.pop());
                }
                st.pop();
                char op = st.pop();
                st.push(operation(list,op));
            }
        }
        return st.pop() == 't' ? true : false;
    }

    private char operation(List<Character> list,char op){
        if(op == '!') return list.get(0) == 't'?'f':'t';

        if(op == '&'){
            for(char c : list){
                if(c == 'f') return 'f';
            }

            return 't';
        }

        for(char c : list){
            if(c == 't') return 't';
        }
        return 'f';
    }
}