class Solution {
    public int divide(int dividend, int divisor) {
         if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;
        if(dividend == divisor){
            return 1;
        }
        boolean sign = true;
        if(dividend >=0 && divisor <0) sign = false;
        if(dividend <0 && divisor >0) sign = false;
       
    

       long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans = 0;
        
        while(n>=d){
            int count = 0;
            while(n>= (d<<count+1)){
                count++;
            }
            ans = ans + (1<<count);
            n = n - (d<<count);
        }
        if(ans>=Math.pow(2,31) && sign ==true){
            return INT_MAX;
        }
        if(ans>=Math.pow(2,31) && sign == false){
            return INT_MIN;
        }
        if(sign == false){
            return -1*ans;
        }else{
            return ans;
        }
        
    }
}