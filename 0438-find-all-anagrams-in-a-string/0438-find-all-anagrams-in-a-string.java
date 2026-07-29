class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans =  new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(n < m) return ans;

        for(int i = 0 ; i<n-m+1 ;i++){
            if(isAnagrams(s.substring(i,i+m),p)){
                ans.add(i);
            }
        }

        return ans;
    }
    private boolean isAnagrams(String s,String p){
        int n = s.length();
        int m = p.length();
        int arr[] = new int[26];

        for(int i = 0 ; i<n ;i++){
            arr[s.charAt(i)-'a']++;
            arr[p.charAt(i)-'a']--;
        }

        for(int i = 0 ;i<26 ; i++){
            if(arr[i] != 0) return false;
        }
        return true;
    }
}