class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;

        for(int x : nums){
            int need = k-x;

            if(map.containsKey(need)){
                if(map.get(need)>0){
                    ans++;
                    map.put(need,map.get(need)-1);
                    if(map.get(need) <= 0) map.remove(need);
                }
            }else{
                map.put(x,map.getOrDefault(x,0)+1);
            }
        }

        return ans;
    }
}