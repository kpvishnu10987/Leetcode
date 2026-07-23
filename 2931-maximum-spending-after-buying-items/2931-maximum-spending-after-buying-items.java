
class Solution {
    public long maxSpending(int[][] values) {
        int n = values.length;
        int m = values[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                pq.offer(values[i][j]);
            }
        }
        long d = 1;
        long ans = 0;
        while(!pq.isEmpty()){
            ans += d * pq.poll();
            d++;
        }
        return ans;
    }
}