class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> fmap = new HashMap<>(); //num -> freq
        PriorityQueue<int[]> map = new PriorityQueue<>((a,b)->a[0]-b[0]); // freq -> list of num
        
        for(int num : nums){
            fmap.put(num,fmap.getOrDefault(num,0) + 1);
        }

        for(int num : fmap.keySet()){
            int freq = fmap.get(num);
            map.offer(new int[]{freq,num});
            if(map.size() > k) map.poll();
        }

        int[] ans = new int[k];
        int j = 0;
        while(!map.isEmpty()){
            ans[j++] = map.poll()[1];
        }
        return ans;


    }
}