class Solution {
    public int minimumPushes(String word) {
        Set<Character> set = new HashSet<>();
        for(char c: word.toCharArray()){
            set.add(c);
        }

        if(set.size() < 9) return set.size();

        int size = set.size();
        int i = 1;
        int ans = 0;

        while(size > 0){
            if(size < 9){
                ans += i*size;
                break;
            }else{
                ans += i*8;
                size-=8;
            }
            i++;
        
        }
        return ans;
    }
}