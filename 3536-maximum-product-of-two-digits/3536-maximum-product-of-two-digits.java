class Solution {
    public int maxProduct(int n) {
        int max = 0;
        int smax = 0;
        while(n > 0){
            int dig = n % 10;
            n = n/10;
            if(dig > max){
                smax = max;
                max = dig;
            }else if(dig == max){
                smax = max;
            }else{
                if(dig > smax){
                    smax = dig;
                }
            }
        }

        return smax * max;
    }
}