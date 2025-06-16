class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ;i<n;i++){
            int curr = asteroids[i];
            if(curr>0){
                ans.add(curr);
            }else{
                while(!ans.isEmpty() && ans.get(ans.size()-1)>0&&ans.get(ans.size()-1) < Math.abs(curr)){
                    ans.remove(ans.size()-1);
                }
                if(!ans.isEmpty() && ans.get(ans.size()-1) == Math.abs(curr)){
                    ans.remove(ans.size()-1);
                }else if(ans.isEmpty() || ans.get(ans.size()-1) < 0){
                    ans.add(curr);
                }
            }
            
        }
        int[] result =  new int[ans.size()];
        for(int i = 0;i<ans.size();i++){
            result[i] = ans.get(i);
        }

        return result;
    }
}