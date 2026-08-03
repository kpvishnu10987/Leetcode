class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        String[] list = s.trim().split("\\s+");
        

        StringBuilder sb = new StringBuilder();

        for(int i = list.length-1 ; i>=0 ; i--){
            sb.append(list[i]);
            if(i != 0) sb.append(' ');
        }

        return sb.toString();
    }
}