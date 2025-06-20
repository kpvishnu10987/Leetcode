class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()<=1){
            return s.length();
        }
        int n =  s.length();
        int maxlen = 0;
        int left=0,right=0;
        Set<Character> set = new HashSet<>();

        while(right < n){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxlen = Math.max(maxlen,right-left+1);
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxlen;
    }
}