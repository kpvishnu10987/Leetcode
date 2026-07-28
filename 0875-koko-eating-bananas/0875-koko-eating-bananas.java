class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1;
        int r = 0;

        for(int p : piles){
            r = Math.max(p,r);
        }

        while(l < r){
            int mid = l + (r-l)/2;

            if(can(mid,piles,h)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    private boolean can(int k,int[] piles,int h){
        int total = 0;

        for(int p : piles){
            if(p <= k){
                total++;
            }else{
                total += p/k;
                if(p%k != 0) total++;
            }
        }

        return total <= h;
    }
}