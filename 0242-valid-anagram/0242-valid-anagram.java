class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m) return false;
        int[] arr = new int[126];
        for(int i = 0 ; i<n ;i++){
            int idx = s.charAt(i)-'a';
            arr[idx]++;
        }
        for(int i = 0 ;i<m ;i++){
            int idx = t.charAt(i)-'a';
            if(arr[idx] <= 0) return false;
            arr[idx]--;
        }

        return true;
        
    }
}