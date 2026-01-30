class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        if(x < 0) return false;

        int rev = 0;

        while(x != 0){
            int l = x % 10;
            rev = rev *10 + l;
            x = x/10;
        }

        return rev-original == 0 ? true : false;
        
    }
}