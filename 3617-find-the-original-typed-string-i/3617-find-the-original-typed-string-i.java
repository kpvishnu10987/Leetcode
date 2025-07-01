class Solution {
    public int possibleStringCount(String word) {
        int output = 1;
        for(int i = 1;i<word.length();i++){
            int j = i-1;
            if(word.charAt(i) == word.charAt(j)){
                output++;
            }
        }
        return output;
    }
}