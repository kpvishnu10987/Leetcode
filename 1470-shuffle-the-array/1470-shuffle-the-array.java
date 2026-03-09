class Solution {
    public int[] shuffle(int[] nums, int n) {
        List<Integer> first = new ArrayList<>(); 
        List<Integer> second = new ArrayList<>(); 
        for(int i = 0; i<n ; i++){
            first.add(nums[i]);
        }
        
        for(int i = n; i<2*n ; i++){
            second.add(nums[i]);
        }
        int k = 0;
        int j = 0;

        for(int i = 0; i<2*n ;i++){
            if(i % 2 == 0){
                nums[i] = first.get(k++);
            }else{
                nums[i] = second.get(j++);
            }
        }

        return nums;

    }
}