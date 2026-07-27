class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;

        int len = 0;
        for(int i = 0 ; i<n ;i++){
            int num  = nums[i] == 0? -1 : 1;
            

            sum += num;
            if(sum == 0) len = i+1;
            if(map.containsKey(sum)){
                len = Math.max(len,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        if(sum == 0) return n;

        return len;
    }
}