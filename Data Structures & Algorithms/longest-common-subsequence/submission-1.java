class Solution {

    private int[][] t;
    private int lcs(String text1, String text2, int i, int j) {
        if(t[i][j]!=-1)
            return t[i][j];
  
        if(i==text1.length() || j==text2.length())
            return 0;
        else if(text1.charAt(i)==text2.charAt(j))
            return t[i][j] = 1 + lcs(text1, text2, i+1, j+1);
        else
            return t[i][j] = Math.max(lcs(text1, text2, i+1, j), lcs(text1, text2, i, j+1));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        t = new int[1001][1001];
        for(int[] arr : t) {
            Arrays.fill(arr, -1);
        }
        return lcs(text1, text2, 0, 0);
    }
}
