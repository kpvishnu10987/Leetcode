class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int a) {
        List<Boolean> ans = new ArrayList<>();
        int max = 0;
        for(int i = 0 ; i<candies.length ; i++){
            max = Math.max(max,candies[i]);
        }

        for(int i = 0 ; i<candies.length ; i++){
            if(candies[i] + a >= max){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }

        return ans;
    }
}