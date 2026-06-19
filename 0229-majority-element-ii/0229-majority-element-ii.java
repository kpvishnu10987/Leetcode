class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int num : nums){
            if(num == max1){
                count1++;
            }else if(num == max2){
                count2++;
            }else{
                if(count1 == 0){
                    max1 = num;
                    count1++;
                }else if(count2 == 0){
                    max2 = num;
                    count2++;
                }else{
                    count1--;
                    count2--;
                }
            }
        }

        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        count1 =0;
        count2 =0;

        for (int num : nums) {
            if (num == max1)
                count1++;
            else if (num == max2)
                count2++;
        }


        if (count1 > n / 3)
            ans.add(max1);

        if (count2 > n / 3 && max1 != max2)
            ans.add(max2);

        return ans;
    }
}