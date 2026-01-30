class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = i+1; j<= n ; j++){
                String sub = s.substring(i,j);
                if(isPal(sub)) count++;
            }
        }

        return count;
        
    }
    private boolean isPal(String t){
        int n = t.length();
        int l = 0 , r = n-1;
        while(l < r){
            if(t.charAt(l++) != t.charAt(r--)) return false;
        }

        return true;
    }
}