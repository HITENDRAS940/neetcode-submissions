class Solution {

    int[][] t;

    private int solve(String w1, String w2, int i, int j) {
        if(w1.length()==i) {
            return w2.length() - j;
        }
        if(w2.length()==j) {
            return w1.length() - i;
        }

        if(t[i][j]!=-1) {
            return t[i][j];
        }

        if(w1.charAt(i)==w2.charAt(j)) {
            return t[i][j] = solve(w1, w2, i+1, j+1);
        }

        int insert = 1 + solve(w1, w2, i, j+1);
        int delete = 1 + solve(w1, w2, i+1, j);
        int replace = 1 + solve(w1, w2, i+1, j+1);

        return t[i][j] = Math.min(Math.min(insert, delete), replace);
    }

    public int minDistance(String word1, String word2) {
        t = new int[101][101];
        for(int[] arr : t) {
            Arrays.fill(arr, -1);
        }
        return solve(word1, word2, 0, 0);
    }
}
