class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1) set1.add(num);
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums2) set2.add(num);
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int num : set1){
            if(!set2.contains(num)) ans1.add(num);
        }

        for(int num :  set2){
            if(!set1.contains(num) ) ans2.add(num);
        }

        ans.add(new ArrayList<>(ans1));
        ans.add(new ArrayList<>(ans2));
        return ans;
    }
}