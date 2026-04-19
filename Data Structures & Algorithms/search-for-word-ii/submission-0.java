class TrieNode {
    public TrieNode[] children;
    public boolean endOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }

    public void addWord(String word) {
        TrieNode cur = this;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (cur.children[i] == null) {
                cur.children[i] = new TrieNode();
            }
            cur = cur.children[i];
        }
        cur.endOfWord = true;
    }

    public void insertAll(String[] words) {
        for (String word : words) {
            addWord(word);
        }
    }
}


class Solution {

    private Set<String> found;
    private boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();
        root.insertAll(words);

        found = new HashSet<>();
        visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                findWords(board, root, row, col, "");
            }
        }

        return new ArrayList<>(found);
    }

    private void findWords(char[][] board, TrieNode node, int r, int c, String word) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[r].length) {
            return;
        }

        if (node.children[board[r][c] - 'a'] == null || visited[r][c]) {
            return;
        }

        visited[r][c] = true;
        node = node.children[board[r][c] - 'a'];
        word += board[r][c];
        if (node.endOfWord) {
            found.add(word);
        }

        findWords(board, node, r + 1, c, word);
        findWords(board, node, r - 1, c, word);
        findWords(board, node, r, c + 1, word);
        findWords(board, node, r, c - 1, word);

        visited[r][c] = false;
    }
    
}
