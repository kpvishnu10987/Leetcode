class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) return false;

        Map<Character,Character> smap = new HashMap<>();
        Map<Character,Character> tmap = new HashMap<>();

        for(int i = 0 ; i<n ; i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(smap.containsKey(sc) && !tmap.containsKey(tc)) return false;
            if(!smap.containsKey(sc) && tmap.containsKey(tc)) return false;

            if((smap.containsKey(sc) && tmap.containsKey(tc)) && (smap.get(sc) != tc &&  tmap.get(tc) != sc)){
                return false;
            }else{
                smap.put(sc,tc);
                tmap.put(tc,sc);
            }
        }

        return true;
    }
}