class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        List<Integer> tail = new ArrayList<>();

        for(int i = 0 ; i<n ; i++){
            int num = nums[i];

            int idx = get(tail,num);

            if(idx == tail.size()){
                tail.add(num);
            }else{
                tail.set(idx,num);
            }

            if(tail.size() >= 3) return true;
        }
        System.out.print(tail);

        

        return tail.size() >= 3;
    }

    private int get(List<Integer> tail,int target){
        int l = 0;
        int r = tail.size();

        while(l < r){
            int mid = l + (r-l)/2;
            
            if(tail.get(mid) < target){
                l = mid+1;
            }else{
                r = mid;
            }

        }
        return l;
    }
}