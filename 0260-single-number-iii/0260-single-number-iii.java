class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for(int num : nums){
            xor ^= num;
        }

        int a = 0;
        int b = 0;
        int i = 0;
        while(((xor >> i) & 1) != 1){
            i++;
        }

        for(int num : nums){
            if(((num >> i) & 1) == 1){
                a ^= num;
            }else{
                b ^= num;
            }
        }

        return new int[]{a,b};

    }
}