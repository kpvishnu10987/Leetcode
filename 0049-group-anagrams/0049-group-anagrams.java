class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

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