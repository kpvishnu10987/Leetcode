class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dis[] = new int[n];

        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;


        for(int i = 0 ; i<= k  ;i++){
            int[] temp = dis.clone();

            for(int[] e : flights){
                int from = e[0];
                int to = e[1];
                int price = e[2];

                if(dis[from]  != Integer.MAX_VALUE){
                    temp[to] = Math.min(temp[to],dis[from] + price);
                }
            }

            dis = temp;
        }

        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}