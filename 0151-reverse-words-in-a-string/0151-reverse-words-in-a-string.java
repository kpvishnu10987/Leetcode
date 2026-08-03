class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        int l = 0;
        
        List<String> list = new ArrayList<>();

        while(l < n){
            while(l < n && s.charAt(l) == ' ') l++;
            if(l >= n) break;

            int end = l;
            while(end < n && s.charAt(end) != ' ') end++;
            list.add(s.substring(l,end));

            l = end;
        }
        

        StringBuilder sb = new StringBuilder();

        for(int i = list.size()-1 ; i>=0 ; i--){
            if(list.get(i) == " ") continue;
            sb.append(list.get(i));
            if(i != 0) sb.append(' ');
        }

        return sb.toString();
    }
}