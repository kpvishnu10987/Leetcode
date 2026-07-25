class Solution {
    List<List<Integer>> ans;
    int n;
    public List<List<Integer>> combinationSum(int[] cd, int target) {
        ans = new ArrayList<>();
        this.n = cd.length;
        f(0,cd,target,new ArrayList<>());
        return ans;
    }

    private void f(int start,int[] cd,int target,List<Integer> sub){
        
            if(target == 0){
                ans.add(new ArrayList<>(sub));
                return;
            }
            if(start == n) return;

        

        if(target < 0) return;

        for(int i = start ; i<n ; i++){
            if(cd[i] > target) continue;
            sub.add(cd[i]);
            f(i,cd,target-cd[i],sub);
            sub.remove(sub.size()-1);
        }

    }
}