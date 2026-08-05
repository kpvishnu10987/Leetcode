class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character,Integer> last = new HashMap<>();

        for(int i = 0 ;i<s.length() ; i++){
            char c = s.charAt(i);
            last.put(c,i);
        }

        int end = 0;
        int start = 0 ;
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i<n ;i++){
            end = Math.max(end,last.get(s.charAt(i)));
            if(i == end){
                ans.add(end-start+1);
                start = end+1;
            }
        }
        return ans;
   
    }
}