class MinStack {
    Stack<Long> st;
    long min ;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(long val) {
        if(st.isEmpty()){
            st.push(val);
            min = val;
        }else{
            if(val>min){
                st.push(val);
            }else{
                st.push(2*val-min);
                min = val;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        long x = st.peek();
        st.pop();
        if(x<min){
            min = 2*min - x;
        }
        
    }
    
    public long top() {
      
        long x =st.peek();
        if(min<x) {
            return x;
        }
        return min;
    }
    
    public long getMin() {
        return min;   
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */