class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    private List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root);
            }
        }
        return result;
    }
    private void dfs(char[][] board, int row, int col, TrieNode node) {
        if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length) {
            return;
        }
        char ch = board[row][col];
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }
        node = node.children[ch - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[row][col] = '#';
        dfs(board, row + 1, col, node);
        dfs(board, row - 1, col, node);
        dfs(board, row, col + 1, node);
        dfs(board, row, col - 1, node);
        board[row][col] = ch;
    }
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }

}