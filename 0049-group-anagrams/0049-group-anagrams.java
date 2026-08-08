class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }
        for(String key : map.keySet()){
            ans.add(map.get(key));
        }

        return ans;
    }
}