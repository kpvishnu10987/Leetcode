class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;
        if(n == 1) return ans;

        int i = 0;
        while(i<n){
            int idx = nums[i]-1;

            while(idx >=0 && idx < n && nums[idx] != nums[i]){
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
                idx = temp-1;
            }
            i++;
        }

        System.out.print(Arrays.toString(nums));
        for(int k = 0 ; k<n ; k++){
            if(nums[k] != k+1) ans.add(nums[k]);
        }

        return ans;

    }
}