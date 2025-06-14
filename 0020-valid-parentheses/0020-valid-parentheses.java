class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        if(n == 0) return true;
        for(int i = 0 ;i<n;i++){
            char item = s.charAt(i);
            char item2 =' ';
            if(i>0 && !st.isEmpty()){
                item2 = st.peek();
            }
            if(st.isEmpty() && (item == ')' || item == '}' || item == ']')  ){
                return false;
            }
            if(item == '(' || item == '{' || item == '[' ){
                st.push(item);
            }
            if((i>0)&&((item == ')' && item2 == '(') || (item == '}' && item2 == '{') || ( item2 == '['&&item == ']') ) ){
                st.pop();
            }
            if(((item == ')' && item2 != '(') || (item == '}' && item2 != '{') || ( item2 != '['&&item == ']') )){
                return false;
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}