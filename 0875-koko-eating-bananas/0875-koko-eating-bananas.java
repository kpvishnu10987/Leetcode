class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1;
        int r = 0;

        for(int p : piles){
            r = Math.max(r,p);
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
        int n = piles.length;

        for(int p : piles){
            total += (p+k-1)/k;
            if(total > h) return false;
        }

        return true;
    }
}