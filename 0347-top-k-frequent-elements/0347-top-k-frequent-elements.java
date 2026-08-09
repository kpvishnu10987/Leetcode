class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        int n = nums.length;

        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }


        List<Integer>[] bucket = new List[n+1];

        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
            
        }

        int idx  = 0;

        for(int i = n ; i>= 1 ; i--){
            if(bucket[i] == null) continue;
            if(idx == k) break;

            List<Integer> ele = bucket[i];
            for(int num : ele){
                ans[idx++] = num;
                if(idx == k) break;
            }
        }
        return ans;
    }
}