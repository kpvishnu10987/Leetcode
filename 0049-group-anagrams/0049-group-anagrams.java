class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        // if(n == 1) {
        //     ans.add(new ArrayList<>(strs[0]));
        //     return ans;
        // }
        // if(n == 0){
        //     ans.add(new ArrayList<>());
        // } 

        int[] vis = new int[n];

        for(int i = 0 ; i<n ;i++){
            List<String> sub = new ArrayList<>();
            if(vis[i] == 1) continue;
            sub.add(strs[i]);
            vis[i] = 1;
            for(int j = i+1 ; j<n ; j++){
                if(vis[j] != 1){
                    if(isAnagram(strs[i],strs[j])){
                        sub.add(strs[j]);
                        vis[j] = 1;
                    }
                }
            }
            ans.add(new ArrayList<>(sub));

        } 

        return ans;
        
    }

    boolean isAnagram(String s,String t){
        if(s.length() != t.length()) return false;

        int[] ss = new int[26];
        int[] tt = new int[26];
        for(int i = 0 ; i<s.length() ; i++){
            ss[s.charAt(i)-'a']++;
            tt[t.charAt(i)-'a']++;
        }

        for(int i = 0 ;i < 26 ; i++){
            if(ss[i] != tt[i]) return false;
        }

        return true;
    }
}