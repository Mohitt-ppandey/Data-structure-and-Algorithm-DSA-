class Solution {
    public String tictactoe(int[][] moves) {
        int n = moves.length;
        char[][] ans = new char[3][3];
        for(int i=0; i<n; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            ans[r][c] = (i%2 == 0) ? 'X' : 'O';
            char ch = ans[r][c];

            // Check row
            if (ans[r][0] == ch && ans[r][1] == ch && ans[r][2] == ch) return ch == 'X' ? "A" : "B";
            // Check column
            if (ans[0][c] == ch && ans[1][c] == ch && ans[2][c] == ch) return ch == 'X' ? "A" : "B";
            //diagonal
            if (r == c && ans[0][0] == ch && ans[1][1] == ch && ans[2][2] == ch) return ch == 'X' ? "A" : "B";
            if (r + c == 2 && ans[0][2] == ch && ans[1][1] == ch && ans[2][0] == ch) return ch == 'X' ? "A" : "B";
        }
        return n == 9 ? "Draw" : "Pending";
    }
}