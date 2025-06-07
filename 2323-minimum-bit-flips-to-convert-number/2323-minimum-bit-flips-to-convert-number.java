class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start^goal;
        String num = Integer.toBinaryString(xor);
        int count = 0;
        for(int i = 0; i<num.length();i++){
            char digit = num.charAt(i);
            if(digit=='1'){
                count++;
            }
        }
    return count;    
    }
}