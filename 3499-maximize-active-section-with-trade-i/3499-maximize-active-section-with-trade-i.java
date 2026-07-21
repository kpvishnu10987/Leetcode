class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        List<Integer> zeros = new ArrayList<>();
        int c = 0;
        int ones = 0;

        for(int i = 0 ; i<n ; i++){
            if(s.charAt(i) == '0'){
                c++;
            }else{
                if(c != 0)zeros.add(c);
                c = 0;
                ones++;
            }
        }
        if(c != 0) zeros.add(c);

        if(zeros.size() == 1) return ones;
        int max = 0;
        for(int i = 0 ;i<zeros.size()-1 ;i++){
            max = Math.max(max,zeros.get(i)+zeros.get(i+1));
            
        }

        System.out.print(zeros);

        return ones+max;
    }
}