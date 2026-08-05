class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> last = new HashMap<>();
        Map<Character,Integer> first = new HashMap<>();

        for(int i = 0 ;i<s.length() ; i++){
            char c = s.charAt(i);
            if(!first.containsKey(c)) first.put(c,i);
            last.put(c,i);
        }

        List<int[]> intervals = new ArrayList<>();
        for(char c : s.toCharArray()){
            intervals.add(new int[]{first.get(c),last.get(c)});
        }
        intervals.sort((a,b)->a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] prev = intervals.get(0);

        for(int i = 1 ;i<intervals.size() ; i++){
            if(prev[1] < intervals.get(i)[0]){
                ans.add(prev);
                prev = intervals.get(i);
            }else{
                prev[1] = Math.max(prev[1],intervals.get(i)[1]);
            }
        }
        ans.add(prev);

        List<Integer> res = new ArrayList<>();
        for(int i = 0 ;i<ans.size() ; i++){
            res.add(ans.get(i)[1]-ans.get(i)[0]+1);
        }

        return res;
    }
}