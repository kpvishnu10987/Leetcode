class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int pgcd[] = new int[n];
        pgcd[0] = nums[0];
        int pmax = nums[0];

        for(int i = 1 ; i<n ; i++){
            pmax = Math.max(nums[i],pmax);
            pgcd[i] = gcd(nums[i],pmax);
        }

        Arrays.sort(pgcd);

        int l = 0 ;
        int r = n-1; 
        long sum = 0;

        while(l < r){
            sum += gcd(pgcd[l],pgcd[r]);
            l++;
            r--;
        }

        return sum;
    }
    private int gcd(int a,int b){
        while(b != 0){
            int t = b; 
            b = a % b;
            a = t;
        }
        return a;
    }
}