class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0 ; i<n  ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            adj.get(b).add(a);
        }

        List<Integer> topo = new ArrayList<>();
        int[] in = new int[n];
        for(int i = 0 ;i<n ;i++){
            for(int it:adj.get(i)){
                in[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ;i<n ;i++){
            if(in[i] == 0){
                q.add(i);
            }
        }

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
        int[] arr = new int[topo.size()];

for (int i = 0; i < topo.size(); i++) {
    arr[i] = topo.get(i);
}
    int[] a =  new int[0];

        return (arr.length == n)?arr:a;



        
    }
}