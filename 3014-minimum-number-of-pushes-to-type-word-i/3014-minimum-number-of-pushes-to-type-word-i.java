class Solution {
    public int minimumPushes(String word) {
        int size = word.length();

        if(size < 9) return size;

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