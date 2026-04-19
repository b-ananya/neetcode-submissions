class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<String, Set<Integer>> squares = new HashMap<>();

        Set<Integer> valid = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {

                if (board[r][c] == '.') {
                    continue;
                }

                int num = (int) board[r][c] - '0';

                // valid symbol
                if (!valid.contains(num)) {
                    return false;
                }

                // rows
                if (!rows.containsKey(r)) {
                    rows.put(r, new HashSet<>());
                    rows.get(r).add(num);
                } else {
                    if (rows.get(r).contains(num)) {
                        return false;
                    } else {
                        rows.get(r).add(num);
                    }
                }

                // cols
                if (!cols.containsKey(c)) {
                    cols.put(c, new HashSet<>());
                    cols.get(c).add(num);
                } else {
                    if (cols.get(c).contains(num)) {
                        return false;
                    } else {
                        cols.get(c).add(num);
                    }
                }

                // square
                int rowS = r / 3;
                int colS = c / 3;
                String squareKey = "" + rowS + "," + colS;

                if (!squares.containsKey(squareKey)) {
                    squares.put(squareKey, new HashSet<>());
                    squares.get(squareKey).add(num);
                } else {
                    if (squares.get(squareKey).contains(num)) {
                        return false;
                    } else {
                        squares.get(squareKey).add(num);
                    }
                }
                
            }
        }

        return true;
        
    }
}
