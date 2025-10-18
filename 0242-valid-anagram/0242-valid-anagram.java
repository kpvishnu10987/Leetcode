class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m) return false;
        HashMap<Character,Integer> h = new HashMap<>();
        for(int i = 0 ; i<n ; i++){
             h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i = 0 ;i<n ;i++){
            if(!h.containsKey(t.charAt(i))){
                return false;
            }
            
            h.put(t.charAt(i),h.get(t.charAt(i))-1);
            if(h.get(t.charAt(i))<0) return false;
        }
        return true;
        
    }
}