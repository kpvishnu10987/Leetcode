class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] freq = new int[26];
            for(int i = 0 ; i<s.length() ; i++){
                freq[s.charAt(i)-'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for(int x : freq){
                sb.append(x).append('&');
            }
            String key = sb.toString();

            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            List<String> sub = map.get(key);
            sub.add(s);
            map.put(key,sub);
        }

        for(String key : map.keySet()){
            ans.add(map.get(key));
        }

        return ans;
    }
}