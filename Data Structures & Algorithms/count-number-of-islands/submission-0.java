class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    numIslands(grid, row, col);
                }
            }
        }

        return count;
        
    }

    private void numIslands(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        numIslands(grid, r + 1, c);
        numIslands(grid, r - 1, c);
        numIslands(grid, r, c + 1);
        numIslands(grid, r, c - 1);
    }
}
