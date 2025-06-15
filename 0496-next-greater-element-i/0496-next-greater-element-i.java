class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int t = -1;
        int k = 0;
        int g = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    g = j;
                    
                    while (g + 1 < nums2.length && nums2[g + 1] <= nums1[i]) {
                        g++;
                    }
                    
                    if (g + 1 < nums2.length && nums2[g + 1] > nums1[i]) {
                        ans[k++] = nums2[g + 1];
                    } else {
                        ans[k++] = t;
                    }
                }
            }
        }
        
        return ans;
    }
}
