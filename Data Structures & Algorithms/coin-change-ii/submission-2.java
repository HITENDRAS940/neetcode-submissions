class Solution {

    int[][] t;

    private int solve(int[] coins, int amount, int i) {

        if (amount == 0)
            return 1;

        if (amount < 0 || i >= coins.length)
            return 0;

        if(t[i][amount]!=-1)
            return t[i][amount];

        // Take current coin
        int take = solve(coins, amount - coins[i], i);

        // Skip current coin
        int skip = solve(coins, amount, i + 1);

        return t[i][amount] = take + skip;
    }

    public int change(int amount, int[] coins) {
        t = new int[101][5001];
        for(int[] arr : t)
            Arrays.fill(arr, -1);
        return solve(coins, amount, 0);
    }
}