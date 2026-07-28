class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<Integer>[] bucket = new ArrayList[n+1];

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int freq = entry.getValue();

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;

        for(int i = n ; i >=0 && idx < k;i--){
            if(bucket[i] == null) continue;

            for(int key : bucket[i]){
                ans[idx] = key;
                idx++;
                if(idx == k) break;
            }
        }

        return ans; 
    }
}