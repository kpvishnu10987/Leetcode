class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex = new int[26];
        for(int i = 0 ; i<order.length() ; i++){
            orderIndex[order.charAt(i)-'a'] = i;
        }

        Comparator<String> compare = (w1,w2)->{
            for(int i = 0 ; i<Math.min(w1.length(),w2.length()); i++){
                if(w1.charAt(i) != w2.charAt(i)){
                    return orderIndex[w1.charAt(i)-'a']-orderIndex[w2.charAt(i)-'a'];
                }
            }

            return w1.length()-w2.length();
        };


        String[] sorted = words.clone();
        Arrays.sort(sorted,compare);

        return Arrays.equals(words,sorted);
        
    }
}