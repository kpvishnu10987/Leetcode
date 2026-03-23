class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> st =  new ArrayDeque<>();

        for(char c : expression.toCharArray()){
            if(c == ',') continue;
            
            if(c == ')'){
                List<Character> vals = new ArrayList<>();
                while(st.peek() != '('){
                    vals.add(st.pop());
                }
                st.pop();
                char ops = st.pop();
                char res = eval(ops,vals);
                st.push(res);
            }else{
                st.push(c);
            }
        }
        char c =  st.pop();
        if(c == 't') return true;
        return false;
    }
    private char eval(char ops,List<Character> vals){
        if(ops == '!'){
            return vals.get(0) == 't'?'f':'t';
        }else if(ops == '|'){
            for(char c : vals){
                if(c == 't') return 't';
            }
            return 'f';
        }else{
            for(char c : vals){
                if(c == 'f') return 'f';
            }
            return 't';
        }
    }
}