class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int index = -1;
        for(int i = n-1 ; i>=0 ; i--){
            char ch = num.charAt(i);

            int number = ch-'0';
            if(number % 2 != 0){
                index = i;
                break;
            }
        }
        
        return index == -1 ? "":num.substring(0,index+1);
        
        
    }
}