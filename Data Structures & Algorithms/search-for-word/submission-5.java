class Solution {
    int [][] directions;
    char[][] board;
    String word;
    public boolean exist(char[][] board, String word) {
        directions = new int [][] {
            {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };
        this.board = board;
        this.word = word;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(dfs(i, j, 0, new boolean[board.length][board[0].length])){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, int i, boolean [][] visit){
        if(r<0 || c <0 || r>= visit.length || c>=visit[0].length 
        || visit[r][c] || i >= word.length() || board[r][c]!= word.charAt(i)){
            return false;
        }

        if(i == word.length() - 1){
            return true;
        }

        visit[r][c] = true;
        boolean res = false;
        for(int [] direction: directions){
            int nr = r + direction[0];
            int nc = c + direction[1];
            res = res || dfs(nr, nc, i+1, visit);
        }
        visit[r][c] = false;
        return res;
    }
}
