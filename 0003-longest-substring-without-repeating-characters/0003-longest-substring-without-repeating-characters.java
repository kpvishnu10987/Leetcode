class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Map<Character,Integer> map = new HashMap<>();
        int l = 0;
        int max = 0;

        for(int r = 0 ; r < n ; r++){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r)) >= l){
                l = map.get(s.charAt(r))+1;
            }
            max = Math.max(max,r-l+1);
            map.put(s.charAt(r),r);
        }
        return max;
    }
}