class Solution {
    public boolean closeStrings(String word1, String word2) {

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(char c : word1.toCharArray())
            map1.put(c, map1.getOrDefault(c,0)+1);

        for(char c : word2.toCharArray())
            map2.put(c, map2.getOrDefault(c,0)+1);

        // Same set of characters must exist
        if(!map1.keySet().equals(map2.keySet()))
            return false;

        Map<Integer,Integer> map3 = new HashMap<>();
        Map<Integer,Integer> map4 = new HashMap<>();

        for(char c : map1.keySet())
            map3.put(map1.get(c), map3.getOrDefault(map1.get(c),0)+1);

        for(char c : map2.keySet())
            map4.put(map2.get(c), map4.getOrDefault(map2.get(c),0)+1);

        return map3.equals(map4);
    }
}