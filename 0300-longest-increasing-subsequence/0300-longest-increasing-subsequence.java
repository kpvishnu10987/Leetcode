class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tail = new ArrayList<>();
        int n = nums.length;

        for(int num : nums){
            int l = 0;
            int r = tail.size();
            int idx = bs(l,r,tail,num);

            if(idx == tail.size()){
                tail.add(num);
            }else{
                tail.set(idx,num);
            }
        }

        return tail.size(); 
    }

    private int bs(int l,int r,List<Integer> tail,int t){
        while(l < r){
            int mid = l + (r-l)/2;
            if(tail.get(mid) < t){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        return l;
    }
}