class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0] // max heap
        );

        for (int[] p : points) {
            int x = p[0], y = p[1];
            int dis = x*x + y*y;

            pq.offer(new int[]{dis, x, y});

            if (pq.size() > k) pq.poll();
        }

        int[][] res = new int[k][2];
        int i = 0;

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            res[i][0] = temp[1];
            res[i][1] = temp[2];
            i++;
        }

        return res;
    }
}