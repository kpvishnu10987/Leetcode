class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        for(int i = n-2 ; i >= 0 ; i--){
            List<Integer> curRow = triangle.get(i);
            List<Integer> belowRow = triangle.get(i+1);

            for(int j = 0 ; j <curRow.size() ; j++){
                int minbelow = Math.min(belowRow.get(j),belowRow.get(j+1));
                curRow.set(j,curRow.get(j)+minbelow);
            }
        }
        return triangle.get(0).get(0);
        
    }
}