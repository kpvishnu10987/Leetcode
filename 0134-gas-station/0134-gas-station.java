class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int tank = 0;
        int total = 0;
        int start =0;

        for(int i =0 ; i<n ; i++ ){
            int diff = gas[i] - cost[i];
            tank += diff;
            total += diff;

            if(tank < 0){
                start = i+1;
                tank = 0;
            }
        }

        if(total < 0){
            return -1;
        }
        return start;
    }
}