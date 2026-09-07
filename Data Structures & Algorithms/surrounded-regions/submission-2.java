class Solution {

    private int[][] dir = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    public void solve(char[][] board) {

        int rows = board.length;
        int columns = board[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        // Put all boundary O's into the queue
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
                board[i][0] = '#';
            }

            if (board[i][columns - 1] == 'O') {
                q.offer(new int[]{i, columns - 1});
                board[i][columns - 1] = '#';
            }
        }

        for (int j = 0; j < columns; j++) {
            if (board[0][j] == 'O') {
                q.offer(new int[]{0, j});
                board[0][j] = '#';
            }

            if (board[rows - 1][j] == 'O') {
                q.offer(new int[]{rows - 1, j});
                board[rows - 1][j] = '#';
            }
        }

        // BFS from boundary O's
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < columns &&
                    board[nr][nc] == 'O') {

                    board[nr][nc] = '#';

                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Flip surrounded O's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}