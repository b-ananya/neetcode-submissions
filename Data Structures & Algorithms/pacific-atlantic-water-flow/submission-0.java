class Solution {
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];

        List<List<Integer>> res = new ArrayList<>();

        for (int c = 0; c < heights[0].length; c++) {
            // pac: top row
            dfs(heights, 0, c, pac);
            // atl: bottom row
            dfs(heights, heights.length - 1, c, atl);
        }

        for (int r = 0; r < heights.length; r++) {
            // pac: left col
            dfs(heights, r, 0, pac);
            // atl: right col
            dfs(heights, r, heights[0].length - 1, atl);
        }
        
        for (int r = 0; r < pac.length; r++) {
            for (int c = 0; c < pac[0].length; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean) {
        ocean[r][c] = true;
        for (int[] dir : directions) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            if (newR >= 0 && newR < ocean.length && newC >= 0 && newC < ocean[0].length && !ocean[newR][newC] && heights[newR][newC] >= heights[r][c]) {
                dfs(heights, newR, newC, ocean);
            }
        }
    }
}
