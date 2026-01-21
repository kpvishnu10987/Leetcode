class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i<numCourses ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            graph.get(arr[1]).add(arr[0]);
        }

        boolean visited[] = new boolean[numCourses];
        boolean path[] = new boolean[numCourses];
        boolean cycle = false;

        for(int i = 0 ; i<numCourses ; i++){
            if(!visited[i]){
                if(dfs(i,path,visited,graph)){
                    cycle = true;
                    break;
                }
            }
        }
        return cycle == true ? false : true;
    }

    private boolean dfs(int node,boolean path[],boolean visited[],List<List<Integer>> graph){
        visited[node] = true;
        path[node] = true;

        for(int nei : graph.get(node)){
            if(!visited[nei] && dfs(nei,path,visited,graph)){
                return true;
            }else if(path[nei]){
                return true;
            }
        }
        path[node] = false;
        return false;
    }
}