class Solution {
    public int maximumSwap(int num) {
        char[] s = String.valueOf(num).toCharArray();
        int n = s.length;

        int[] last = new int[10];

        for(int i = 0 ; i<n; i++){
            last[s[i]-'0'] = i;
        }

        for(int i  = 0 ;i<n ; i++){
            for(int d = 9 ; d > s[i]-'0' ; d--){
                if(last[d] > i){
                    char temp = s[i];
                    s[i] = s[last[d]];
                    s[last[d]] = temp;

                    return Integer.parseInt(new String(s));
                }
            }
        }
        return num;
    }
}