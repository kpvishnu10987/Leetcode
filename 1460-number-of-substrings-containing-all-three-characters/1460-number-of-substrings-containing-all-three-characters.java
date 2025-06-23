class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int count = 0;
        int[] map = new int[3];
        for(int right = 0 ;right < n ;right++){
            map[s.charAt(right)-'a']++;
            while(map[0] >= 1 && map[1] >= 1 && map[2] >=1){
                count += (n-right);
                map[s.charAt(left)-'a']--;
                left++;
            }
        }
        return count;
        
    }
}