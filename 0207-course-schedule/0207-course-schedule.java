class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            
            adj.get(b).add(a);
        }

        int[] in = new int[numCourses];
        for(int i= 0 ; i<numCourses ; i++){
            for(int it : adj.get(i)){
                in[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i<numCourses ; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int it : adj.get(node)){
                in[it]--;
                if(in[it] == 0){
                    q.add(it);
                }
            }

        }
        return topo.size() == numCourses;
        
    }
}