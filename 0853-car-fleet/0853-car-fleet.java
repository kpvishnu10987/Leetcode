import java.util.*;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        Integer[] idx = new Integer[position.length];

        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }

        // Sort indices by position descending
        Arrays.sort(idx, (a, b) -> position[b] - position[a]);

        int fleets = 0;
        double prevTime = 0;

        for (int i : idx) {

            double time = (double)(target - position[i]) / speed[i];

            if (time > prevTime) {
                fleets++;          // new fleet
                prevTime = time;   // update slowest fleet time
            }
        }

        return fleets;
    }
}
