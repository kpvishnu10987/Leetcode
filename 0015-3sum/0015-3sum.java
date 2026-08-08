class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i<n ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int a = nums[i];

            int l = i+1 ;
            int r = n-1;

            while(l < r){
                int b = nums[l];
                int c = nums[r];
                int sum = a+ b+ c;
                if(sum == 0){
                    ans.add(new ArrayList<>(List.of(a,b,c)));

                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l-1]) l++;
                    while(l < r && nums[r] == nums[r+1]) r--;
                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }

        }
        return ans;
        
    }
}