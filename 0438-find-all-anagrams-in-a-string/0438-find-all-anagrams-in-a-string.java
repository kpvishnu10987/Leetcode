class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans =  new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(n < m) return ans;

        int[] need = new int[26];
        for(int i = 0 ; i< m; i++){
            need[p.charAt(i)-'a']++;
        }
        int l =0;
        int[] matched = new int[26];

        for(int r = 0 ; r<n ; r++){
            matched[s.charAt(r)-'a']++;

            if(r-l+1 > m){
                matched[s.charAt(l)-'a']--;
                l++;
            }

            if(r-l+1 == m){
                if(Arrays.equals(need,matched)){
                    ans.add(l);
                }
            }
        }

        return ans;
    }
}