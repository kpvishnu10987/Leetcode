class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->b-a);
        for(int i = 0 ;i<nums.length;i++){
            maxheap.add(nums[i]);
        }
        int kth_largest = 0;
        for(int i = 0;i<k;i++){
            kth_largest = maxheap.poll();
        }
        return kth_largest;
    }
}