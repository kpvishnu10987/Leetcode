class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int max = 0;
        for(int i = 0 ;i<n ; i++){
            int num = nums[i] == 0 ? -1 : 1;

            sum += num;
            if(sum == 0) max = i+1;

            int req = sum;

            if(map.containsKey(req)){
                max = Math.max(max,i-map.get(req));
            }

            if(!map.containsKey(sum))
                map.put(sum,i);
        }
    
        
        return max;
    }
}