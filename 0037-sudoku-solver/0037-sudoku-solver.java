class Solution {

    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {

        // Initialize constraint tables
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    continue;
                }

                int digit = board[row][col] - '0';
                int box = getBox(row, col);

                rows[row][digit] = true;
                cols[col][digit] = true;
                boxes[box][digit] = true;
            }
        }

        solve(board);
    }

    private boolean solve(char[][] board) {

        int bestRow = -1;
        int bestCol = -1;
        int bestCount = 10;

        // Find the empty cell with minimum candidates
        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] != '.') {
                    continue;
                }

                int box = getBox(row, col);

                int count = 0;

                for (int digit = 1; digit <= 9; digit++) {

                    if (!rows[row][digit] &&
                        !cols[col][digit] &&
                        !boxes[box][digit]) {

                        count++;
                    }
                }

                // No possible digit
                if (count == 0) {
                    return false;
                }

                // Best cell found
                if (count < bestCount) {

                    bestCount = count;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        // No empty cells → solved
        if (bestRow == -1) {
            return true;
        }

        int box = getBox(bestRow, bestCol);

        // Try every possible digit
        for (int digit = 1; digit <= 9; digit++) {

            if (rows[bestRow][digit] ||
                cols[bestCol][digit] ||
                boxes[box][digit]) {

                continue;
            }

            // Choose
            board[bestRow][bestCol] =
                (char) ('0' + digit);

            rows[bestRow][digit] = true;
            cols[bestCol][digit] = true;
            boxes[box][digit] = true;

            // Explore
            if (solve(board)) {
                return true;
            }

            // Backtrack
            board[bestRow][bestCol] = '.';

            rows[bestRow][digit] = false;
            cols[bestCol][digit] = false;
            boxes[box][digit] = false;
        }

        return false;
    }

    private int getBox(int row, int col) {

        return (row / 3) * 3 + (col / 3);
    }
}