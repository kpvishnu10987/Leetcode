class Solution {
    Map<String,PriorityQueue<String>> map = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> list : tickets){
            String from = list.get(0);
            String to = list.get(1);

            map.putIfAbsent(from,new PriorityQueue<>());
            map.get(from).offer(to);
        }

        dfs("JFK");

        Collections.reverse(ans);
        return ans;
    }

    void dfs(String s){
        PriorityQueue<String> pq = map.get(s);
        while(pq != null && !pq.isEmpty()){
            String t = pq.poll();
            dfs(t);
        }

        ans.add(s);
    }
}