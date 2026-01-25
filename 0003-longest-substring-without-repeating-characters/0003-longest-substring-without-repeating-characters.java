class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character,Integer> map= new HashMap<>(); 
        int count = 0;
        int maxc = 0;

        int i = 0;
        int j = 0;
        while(j<n && i < n){
            char c = s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            count++;
            while(map.get(c) > 1){
                char r = s.charAt(i);
                map.put(r,map.get(r)-1);
                count--;
                if(map.get(r) <=0){
                    map.remove(r);
                }
                i++;
            }

            maxc = Math.max(maxc,count);
            j++;
        }

        return maxc;
        
    }
}