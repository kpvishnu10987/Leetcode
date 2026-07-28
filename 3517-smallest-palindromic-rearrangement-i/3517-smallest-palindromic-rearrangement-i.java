class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();

        int[] arr = new int[26];

        for(char c : s.toCharArray()){
            arr[c-'a']++;
        }

        char mid = 'a';
        boolean check = false;
        StringBuilder first = new StringBuilder();
        for(int i = 0 ;i<26 ; i++){
            if(arr[i] % 2 != 0){
                mid = (char) (i+'a');
                check = true;
                arr[i]--;
            }
            int req = arr[i] / 2; 

            while(req-- > 0){
                first.append((char)(i+'a'));
            }
        }

        StringBuilder second = new StringBuilder(first).reverse();

        if(check) first.append(mid);
        String t = first.append(second).toString();

        return t;




    }
}