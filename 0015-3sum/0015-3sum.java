class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i<n ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = n-1;

            while(l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if(sum == 0){
                    ans.add(new ArrayList<>(List.of(nums[i],nums[l],nums[r])));
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]) l++;
                    while(l < r && nums[r] == nums[r+1]) r--;
                }else if(sum > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }

        return ans;
    }
}