class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set[] rows = new Set[9];
        Set[] columns = new Set[9];
        Map<String, Set<Character>> squares = new HashMap<>();
        for(int i =0; i<9; i++){
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();

        }
        for(int i =0; i<board.length; i++){
            for(int j =0; j<board[i].length; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                //[i/3,j/3]
                String square = i/3 + ","+ j/3;
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
            
if(!squares.containsKey(square)){
                    squares.put(square, new HashSet<>());
                }
                    if(squares.get(square).contains(board[i][j])){
                        return false;
                    } else {
                        squares.get(square).add(board[i][j]);
                    }

            }
        }

        return true;
    }
}
