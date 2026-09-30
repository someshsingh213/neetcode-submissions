class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set[] rows = new Set[9];
        Set[] columns = new Set[9];
        Set[] squares = new Set[9];
        for(int i =0; i<9; i++){
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }
        for(int i =0; i<board.length; i++){
            for(int j =0; j<board[i].length; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                //[i,j]
                int square = (i/3)*3 + j/3;
                    if(rows[i].contains(board[i][j])){
                        return false;
                    } else {
                        rows[i].add(board[i][j]);
                    }

                    if(columns[j].contains(board[i][j])){
                        return false;
                    } else {
                        columns[j].add(board[i][j]);
                    }
            

                    if(squares[square].contains(board[i][j])){
                        return false;
                    } else {
                        squares[square].add(board[i][j]);
                    }

            }
        }

        return true;
    }
}
