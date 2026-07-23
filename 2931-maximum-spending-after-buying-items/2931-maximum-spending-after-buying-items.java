class Pair{
    int val;
    int r;
    int c;
    Pair(int val,int r,int c){
        this.val = val;
        this.r = r;
        this.c = c;
    }
}
class Solution {
    public long maxSpending(int[][] values) {
        int n = values.length;
        int m = values[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.val-b.val);

        for(int i = 0 ; i<n ; i++){
            pq.offer(new Pair(values[i][m-1],i,m-1));
        }
        long d = 1;
        long ans = 0;

        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int v = node.val;
            int i = node.r;
            int j = node.c;

            ans += d * v;
            d++;

            if(j-1 >= 0){
                pq.offer(new Pair(values[i][j-1],i,j-1));
            }
        }

        return ans;
    }
}