class Solution {
    public int maxProduct(int n) {
        List<Integer> nums = new ArrayList<>();
        while(n > 0){
            int dig = n % 10;
            n = n/10;
            nums.add(dig);
        }

        Collections.sort(nums);
        return nums.get(nums.size()-1) * nums.get(nums.size()-2);
    }
}