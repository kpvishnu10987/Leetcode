class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[rooms.size()];

        q.offer(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0 ; i<n ; i++){
                int node = q.poll();

                for(int nei : rooms.get(node)){
                    if(!vis[nei]){
                        vis[nei] = true;
                        q.offer(nei);
                    }
                }
            }
        }

        for(int i = 0 ; i<rooms.size() ; i++){
            if(!vis[i]) return false;
        }

        return true;
    }
}