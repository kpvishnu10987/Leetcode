class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int min = 1001;
        int max = 0;
        for(int num : nums){
            min = Math.min(num,min);
            max = Math.max(num,max);
        }
        return gcd(min,max);
    }

    private int gcd(int a,int b){
        while(b != 0){
            int t = b;
             b = a % b;
             a = t;
            
        }
        return a;
    }
}