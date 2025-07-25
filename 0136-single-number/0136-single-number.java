class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        if(n <= 1){
            return nums[0];
        }
        while(j<n && i<n && nums[i] == nums[j] ){
            i = j+1;
            j = i+1;
        }
        return nums[i];

    }
}