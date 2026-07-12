class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if(n == 0) return new int[0];
        if(n == 1) return new int[]{1};

        int[] sorted = new int[n];
        for(int i = 0 ; i< n ; i++){
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        Map<Integer,Integer> map = new HashMap<>();
        int rank = 1;
        map.put(sorted[0],1);

        for(int i = 1 ; i<n ; i++){
            if(sorted[i] == sorted[i-1]){
                map.put(sorted[i],rank);
            }else{
                rank++;
                map.put(sorted[i],rank);
            }
        }

        for(int i = 0 ; i<n ; i++){
            sorted[i] = map.get(arr[i]);
        }

        return sorted;
    }
}