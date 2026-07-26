class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        int l1 = Integer.MIN_VALUE;
        int l2 = Integer.MIN_VALUE;
        int l3 = Integer.MIN_VALUE;
        int s1 = Integer.MAX_VALUE;
        int s2 = Integer.MAX_VALUE;

        for(int num : nums){
            if(num > l1){
                l3 = l2;
                l2 = l1;
                l1 = num;
            }else if(num > l2){
                l3 = l2;
                l2 = num;
            }else if(num > l3){
                l3 = num;
            }

            if(num < s1){
                s2 = s1;
                s1 = num;
            }else{
                s2 = Math.min(s2,num);
            }
        }

        return Math.max(l1*l2*l3,l1*s1*s2);
    }
}