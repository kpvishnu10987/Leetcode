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
            if(can(piles,h,mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return l;
    }

    private boolean can(int[] piles,int max,int rate){
        int total = 0;
        for(int p : piles){
            if(rate > p){
                total++;
            }else{
                total += p / rate;
                if(p % rate != 0) total++;
            }
            if(total > max) return false;
        }
        return total <= max;
    }
}