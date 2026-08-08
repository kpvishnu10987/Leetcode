class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int key : map.keySet()){
            pq.offer(new int[]{map.get(key),key});
            if(pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];

        for(int i = 0 ;i<k ;i++){
            ans[i] = pq.poll()[1];
        }

        return ans;
    }
}