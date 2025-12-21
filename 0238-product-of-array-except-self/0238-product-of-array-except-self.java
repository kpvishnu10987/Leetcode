class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixproduct = new int[n];
        int[] sufixproduct = new int[n];
        prefixproduct[0] = 1;
        sufixproduct[n-1] = 1;
        for(int i = 1 ; i<n ; i++){
            prefixproduct[i] = prefixproduct[i-1]*nums[i-1]; 
        }

        for(int i=n-2 ; i>=0 ; i--){
            sufixproduct[i] = sufixproduct[i+1]*nums[i+1];
        }

        int[] result = new int[n];
        for(int i = 0 ; i<n ;i++){
            result[i] = prefixproduct[i]*sufixproduct[i];
        }

        return result;

    }
}