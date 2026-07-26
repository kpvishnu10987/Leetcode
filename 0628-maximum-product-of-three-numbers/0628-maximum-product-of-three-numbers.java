class Solution {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> h1 = new PriorityQueue<>();
        PriorityQueue<Integer> h2 = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            h1.offer(num);
            h2.offer(num);

            if(h1.size() > 3) h1.poll();
            if(h2.size() > 2) h2.poll();
        }

        int ans1 = 1;
        int ans2 = 1;
        while(!h1.isEmpty()){
            if(h1.size() == 1) ans2 *= h1.peek();
            ans1 *= h1.poll();
        }

        while(!h2.isEmpty()){
            ans2 *= h2.poll();
        }
        return Math.max(ans1,ans2);
    }
}