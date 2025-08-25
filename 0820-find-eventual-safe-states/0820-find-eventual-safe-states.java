class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ////not matrix representaion 
        int n = graph.length;
        
        // reverse graph
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) rev.add(new ArrayList<>());
        
        int[] indegree = new int[n];
        
        // build reverse graph + indegree of original
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                rev.get(v).add(u);   // reverse edge: v -> u
                indegree[u]++;       // indegree in original graph
            }
        }
        
        // queue of terminal nodes (indegree 0 in original)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        // BFS
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for (int prev : rev.get(node)) {
                indegree[prev]--;
                if (indegree[prev] == 0) {
                    q.add(prev);
                }
            }
        }
        
        Collections.sort(ans); // sorted result
        return ans;
    }
}
