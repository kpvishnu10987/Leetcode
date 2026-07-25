class Solution {
    public int[] singleNumber(int[] nums) {
        int total  = 0;

        for(int num : nums){
            total ^= num;
        }

        int bit = 0;
        while((total & (1 << bit)) != (1 << bit)){
            bit++;
        }
        int mask = (1 << bit);

        int a = 0;
        int b = 0;


        for(int num : nums){
            if((num & mask) == 0){
                a ^= num;
            }else{
                b ^= num;
            }
        }

        return new int[]{a,b};
        
    }
}