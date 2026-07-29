class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n < m) return new String();
        

        int tcount = 0;
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> tmap = new HashMap<>();

        for(char c : t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
            tcount++;
        }
        int l= 0;
        int min = Integer.MAX_VALUE;
        int start = 0;

        for(int r = 0 ; r<n ; r++){
            char rc = s.charAt(r);
            smap.put(rc,smap.getOrDefault(rc,0)+1);
            if(tmap.containsKey(rc) && smap.get(rc) <= tmap.get(rc)) tcount--;

            while(tcount == 0){
                char lc = s.charAt(l);
                if(min > r-l+1){
                    start = l;
                    min = r-l+1;
                }
                int count = smap.get(lc);
                if(count == 1){
                    smap.remove(lc);
                }else{
                    smap.put(lc,smap.get(lc)-1);
                }
                 if(tmap.containsKey(lc) && tmap.get(lc) > smap.getOrDefault(lc,0)){
                        tcount++;
                    }
                l++;
            }

        }
            return min == Integer.MAX_VALUE ? "" :s.substring(start,start+min);
    }
}