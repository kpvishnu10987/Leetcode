class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        int count = 0;

        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
            count++;
        }

        int l = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;

        for (int r = 0; r < n; r++) {
            char rc = s.charAt(r);

            smap.put(rc, smap.getOrDefault(rc, 0) + 1);
            if(tmap.containsKey(rc) && smap.get(rc) <= tmap.get(rc)){
                count--;
            }

            while (count == 0) {
                char lc = s.charAt(l);
                if(min > r-l+1){
                    min = r-l+1;
                    start = l;
                }
                

                smap.put(lc, smap.get(lc) - 1);
                if(tmap.containsKey(lc) && smap.get(lc) < tmap.get(lc)){
                    count++;
                }
                if (smap.get(lc) <= 0)
                    smap.remove(lc);
                l++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start,start+min);
    }


}