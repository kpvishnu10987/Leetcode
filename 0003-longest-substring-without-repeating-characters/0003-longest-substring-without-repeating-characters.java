class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int max = 0;

        Map<Character,Integer> map = new HashMap<>();
        int l = 0;

        for(int i = 0 ; i<n ; i++){
            char rc = s.charAt(i);

            if(map.containsKey(rc)){
                l = Math.max(l,map.get(rc)+1);
            }
            map.put(rc,i);
            max = Math.max(max,i-l+1);
        }

        return max;
    }
}