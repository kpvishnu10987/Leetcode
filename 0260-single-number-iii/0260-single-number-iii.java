class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0 ;
        int[] ans = new int[2];
        for( int i=0;i<nums.length;i++){
            xor = xor^nums[i];
        }
        int rightmost = (xor & (xor-1))^xor;
        int b1=0,b2=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & rightmost) != 0){
                b1 = b1 ^ nums[i];
            }else{
                b2 = b2 ^ nums[i];
            }
        }
        ans[0]=b1;
        ans[1] = b2;
        return ans;
        
        
    }
}