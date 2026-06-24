import java.util.*;

class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    Boolean[][] memo;
    int[] stones;

    public boolean canCross(int[] stones) {

        this.stones = stones;
        int n = stones.length;

        // First jump must be 1
        if (n > 1 && stones[1] != 1)
            return false;

        // Position -> Index
        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        memo = new Boolean[n][n + 1];

        return dfs(1, 1);
    }

    private boolean dfs(int index, int lastJump) {

        if (index == stones.length - 1)
            return true;

        if (memo[index][lastJump] != null)
            return memo[index][lastJump];

        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {

            if (jump <= 0)
                continue;

            int nextPosition = stones[index] + jump;

            if (map.containsKey(nextPosition)) {

                int nextIndex = map.get(nextPosition);

                if (dfs(nextIndex, jump)) {
                    return memo[index][lastJump] = true;
                }
            }
        }

        return memo[index][lastJump] = false;
    }
}