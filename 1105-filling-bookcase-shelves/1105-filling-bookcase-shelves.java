class Solution {
    int width;
    int[][] books;
    int n;
    int dp[];
    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.books = books;
        this.width = shelfWidth;
        n = books.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return f(0);
    }

    private int f(int i){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];

        int curwidth = 0;
        int maxheight = 0;
        int ans = Integer.MAX_VALUE;

        for(int j = i ; j<n ; j++){
            curwidth += books[j][0];

            if(curwidth > width)
                break;

            maxheight = Math.max(books[j][1],maxheight);

            ans = Math.min(ans,maxheight + f(j+1));
        }

        return dp[i] = ans;
    }
}