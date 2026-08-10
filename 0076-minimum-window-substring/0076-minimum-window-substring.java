class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m > n) return "";

        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }

        int l = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        for(int r = 0 ; r< n ; r++){
            char rc = s.charAt(r);
            smap.put(rc,smap.getOrDefault(rc,0)+1);

            while(valid(smap,tmap)){
                
                if(min > r-l+1){
                    start = l;
                    min = r-l+1;
                }
                char lc = s.charAt(l);
                smap.put(lc,smap.get(lc)-1);
                l++;
            }
            
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start,start+min);
    }
    boolean valid(Map<Character,Integer> smap,Map<Character,Integer> tmap){
        for(char key : tmap.keySet()){
            if(!smap.containsKey(key)) return false;
            if(smap.get(key) < tmap.get(key)) return false;
        }

        return true;
    }
}