class Solution {
    public int numberOfWays(String s) {
        int n = s.length();

        long plant = 1;
        int total = 0;

        for(char c : s.toCharArray()){
            if(c == 'S') total++;
        }

        if(total == 0 || total % 2 != 0) return 0;

        int i = 0;
        int seat = 0;
        while(i < n){
            while(i<n && seat <2){
                if(s.charAt(i) == 'S') seat++;
                i++;
            }
            int p = 0;
            while(i<n && seat == 2){
                if(s.charAt(i) == 'P') p++;
                if(s.charAt(i) == 'S') seat = 1;
                i++;
                if(i == n) p = 0;
            }
            plant = (plant*(p + 1))%1_000_000_007;
        }

        return (int)plant;


    }
}