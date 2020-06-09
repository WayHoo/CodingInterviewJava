package _12_StringPathInMatrix;

/**
 * @author huwei
 * @date 2020/6/7 13:13
 * @leetcode https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class StringPathInMatrix {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        if( word == null || word.length() == 0 || board.length == 0 || board[0].length == 0 )
            return false;
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        return findChar(board, isVisited, word, 0, 0, 0);
    }

    public static boolean findChar(char[][] board, boolean[][] isVisited,
                                   String word, int board_i, int board_j, int word_index) {
        if( word_index == word.length() )
            return true;
        if( word_index == 0 ){
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if( board[i][j] == word.charAt(word_index) ) {
                        isVisited[i][j] = true;
                        if( findChar(board, isVisited, word, i, j, word_index + 1) )
                            return true;
                        isVisited[i][j] = false;
                    }
                }
            }
            return false;
        }
        int[][] step = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int i = 0; i < step.length; i++) {
            int tmp_i = board_i + step[i][0];
            int tmp_j = board_j + step[i][1];
            if( tmp_i >= 0 && tmp_i < board.length &&
                    tmp_j >= 0 && tmp_j < board[0].length &&
                    !isVisited[tmp_i][tmp_j] &&
                    board[tmp_i][tmp_j] == word.charAt(word_index) ){
                isVisited[tmp_i][tmp_j] = true;
                if( findChar(board, isVisited, word, tmp_i, tmp_j, word_index + 1) )
                    return true;
                isVisited[tmp_i][tmp_j] = false;
            }
        }
        return false;
    }
}
