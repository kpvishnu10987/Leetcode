class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int target = n/2;

        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > target){
                return entry.getKey();
            }
        }
        return 0;
        
    }
}