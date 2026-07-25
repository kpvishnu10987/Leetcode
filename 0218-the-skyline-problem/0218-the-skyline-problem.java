class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for(int[] b : buildings){
            events.add(new int[]{b[0],-b[2]});
            events.add(new int[]{b[1],b[2]});
        }

        events.sort((a,b) -> {
            if(a[0] != b[0])
                return a[0]-b[0];
            return a[1]-b[1];
        });

        TreeMap<Integer,Integer> hei = new TreeMap<>();
        hei.put(0,1);

        int prev = 0;
        List<List<Integer>> ans = new ArrayList<>();

        for(int e[] : events){
            int x = e[0];
            int h = e[1];

            if(h < 0){
                h = -h;
                hei.put(h,hei.getOrDefault(h,0)+1);
            }else{
                int count = hei.get(h);

                if(count == 1){
                    hei.remove(h);
                }else{
                    hei.put(h,hei.get(h)-1);
                }
            }

            int cur = hei.lastKey();

            if(cur != prev){
                ans.add(new ArrayList<>(List.of(x,cur)));
                prev = cur;
            }
        }

        return ans;
    }
}