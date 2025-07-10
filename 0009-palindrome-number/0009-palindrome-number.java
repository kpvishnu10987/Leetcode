class Solution {
    public boolean isPalindrome(int x) {
        String st = String.valueOf(x);
        int n = st.length();
        int left = 0;
        int right = n-1;
        while(left < right){
            if(st.charAt(left) == st.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
        
    }
}