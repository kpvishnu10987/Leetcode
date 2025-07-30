class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub1 = new ArrayList<>();
        sub1.add(1);
        ans.add(new ArrayList<>(sub1));
        int row = 1;
        
        while(row != numRows){
            List<Integer> sub = new ArrayList<>();
            List<Integer> prev = ans.get(row-1);
            int prevSize = prev.size();
            sub.add(1);
            for(int i = 0; i<prevSize-1 ; i++){
                int j = i+1;
                int ele = prev.get(i) + prev.get(j);
                sub.add(ele);
            }
            sub.add(1);
            ans.add(new ArrayList<>(sub));
            row++;
        }

        return ans;
    }
}