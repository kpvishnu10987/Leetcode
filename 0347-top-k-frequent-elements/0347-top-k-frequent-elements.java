class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> fmap = new HashMap<>(); //num -> freq
        List<Integer>buck[] = new ArrayList[n+1];
        
        for(int num : nums){
            fmap.put(num,fmap.getOrDefault(num,0) + 1);
        }

        for(int num : fmap.keySet()){
            int freq = fmap.get(num);
            if(buck[freq] == null){
                buck[freq] = new ArrayList<>();
            }
            buck[freq].add(num);
        }

        int[] ans = new int[k];
        int j = 0;
        for(int i = n ; i>=0 ; i--){
            if(buck[i] == null) continue;
            
            List<Integer> list = buck[i];
            for(int x = 0 ; x<list.size() ; x++){
                ans[j++] = list.get(x);
                if(j == k) return ans;;
            }
        }
        return ans;


    }
}