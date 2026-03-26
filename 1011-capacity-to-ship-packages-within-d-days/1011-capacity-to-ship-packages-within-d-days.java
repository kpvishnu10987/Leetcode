class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        for (int w : weights) {
            low = Math.max(low, w); // min capacity
            high += w;              // max capacity
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1; // try smaller
            } else {
                low = mid + 1;  // increase capacity
            }
        }

        return ans;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int current = 0;
        int d = 1;

        for (int w : weights) {
            if (current + w > cap) {
                d++;
                current = 0;
            }
            current += w;
        }

        return d <= days;
    }
}