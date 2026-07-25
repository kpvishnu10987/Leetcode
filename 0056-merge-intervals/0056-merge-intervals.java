class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr,(a,b) -> a[0]-b[0]);

        int n = arr.length;
        List<int[]> list = new ArrayList<>();

        int[] prev = arr[0];

        for(int i = 1 ; i<n ; i++){
            if(prev[1] < arr[i][0]){
                list.add(prev);
                prev = arr[i];
            }else{
                prev[1] = Math.max(prev[1],arr[i][1]);
            }
        }

        list.add(prev);

        return list.toArray(new int[list.size()][]);
    }
}