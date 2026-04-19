class Solution {
    public boolean exist(char[][] board, String word) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (exist(board, r, c, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;    
    }

    private boolean exist(char[][] board, int r, int c, String word, int i) {
        if (word.length() == i) {
            return true;
        }

        if (r >= board.length || r < 0 || c < 0 || c >= board[r].length || board[r][c] != word.charAt(i) || board[r][c] == '*') {
            return false;
        }

        board[r][c] = '*';
        boolean result = (exist(board, r + 1, c, word, i + 1) || exist(board, r - 1, c, word, i + 1)
            || exist(board, r, c + 1, word, i + 1) || exist(board, r, c - 1, word, i + 1));

        board[r][c] = word.charAt(i);
        return result;
    }
}
