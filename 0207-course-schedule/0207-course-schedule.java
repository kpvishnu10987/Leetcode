class Edge {
    int src;
    int dest;
    public Edge(int s, int d) {
        this.src = s;
        this.dest = d;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Edge>[] graph =  new ArrayList[numCourses];
        
        for(int i = 0 ;i<numCourses ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i<prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph[b].add(new Edge(b,a));
        }

        int[] in = new int[numCourses];
        for(int i = 0 ; i<numCourses; i++){
            for(Edge e : graph[i]){
                in[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) q.add(i);
        }

        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(Edge e : graph[node]){
                in[e.dest]--;
                if(in[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

        return numCourses == topo.size();
    }
}