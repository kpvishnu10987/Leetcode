class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }

        int m = A.length, n = B.length;
        int low = 0, high = m;

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : A[cut1 - 1];
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : A[cut1];

            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : B[cut2 - 1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : B[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }
            else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}