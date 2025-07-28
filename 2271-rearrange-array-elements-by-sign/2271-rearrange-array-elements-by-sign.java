class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        for(int num : nums){
            if(num < 0){
                neg.offer(num);
            }else{
                pos.offer(num);
            }
        }
        for(int i = 0 ; i<nums.length ; i++){
            if(i%2 == 0){
                nums[i] = pos.poll();
            }else{
                nums[i] = neg.poll();
            }
        }
        return nums;
        
    }
}