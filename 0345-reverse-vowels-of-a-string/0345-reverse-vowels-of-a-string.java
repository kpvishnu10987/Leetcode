class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();
        boolean[] oval = new boolean[n];
        List<Character> list = List.of('a','e','i','o','u','A','E','I','O','U');

        int l = 0;
        int r = n-1;

        for(int i = 0 ; i<n ; i++){
            if(list.contains(s.charAt(i))) oval[i] = true;
        }

        while(l < r){
            while(l < r && !oval[l]) l++;
            while(l < r && !oval[r]) r--;

            char temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;

            l++;
            r--;
        }

        return new String(arr);
    }

}