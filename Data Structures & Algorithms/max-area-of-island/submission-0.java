class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int area = islandArea(grid, row, col);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }

        return max;
        
    }

    private int islandArea(int[][] grid, int r, int c) {

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        return 1 + islandArea(grid, r + 1, c) + islandArea(grid, r - 1, c) + islandArea(grid, r, c + 1) + islandArea(grid, r, c - 1);
    }
}
