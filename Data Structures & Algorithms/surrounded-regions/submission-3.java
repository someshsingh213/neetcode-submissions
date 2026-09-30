class Solution {
    public void solve(char[][] board) {
        //convert any edge 0s to T and also add them to the queue to run BFS
        Queue<int []> queue = new LinkedList<>();
        
        for(int i = 0; i<board.length; i++){
            for(int j =0; j<board[i].length; j++){
                if((i == 0 || j == 0 || i == board.length-1 || j == board[i].length - 1) && board[i][j] == 'O'){
                    board[i][j] = 'U';
                    queue.offer(new int [] {i, j});
                }
            }
        }

        Set<int []> visit = new HashSet<>();
        
        while(!queue.isEmpty()) {
            int [] pair = queue.poll();
            int row = pair[0];
            int col = pair[1];

            if(visit.contains(pair)){
                continue;
            }
            //top
            if(row - 1 >= 0 && !visit.contains(new int [] {row - 1, col}) && board[row-1][col] == 'O') {
                board[row - 1][col] = 'U';
                queue.offer(new int [] {row -1, col});
            }
            //right
            if(col + 1 < board[0].length && !visit.contains(new int [] {row, col+1}) && board[row][col+1] == 'O') {
                board[row][col+1] = 'U';
                queue.offer(new int [] {row, col+1});
            }
            //bottom
            if(row + 1 < board.length && !visit.contains(new int [] {row + 1, col}) && board[row+1][col] == 'O') {
                board[row + 1][col] = 'U';
                queue.offer(new int [] {row +1, col});
            }
            //left
            if(col - 1 >= 0 && !visit.contains(new int [] {row, col-1}) && board[row][col-1] == 'O') {
                board[row][col-1] = 'U';
                queue.offer(new int [] {row, col-1});
            }
            visit.add(pair);
        }

        for(int i = 0; i<board.length; i++){
            for(int j =0; j<board[i].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        for(int i = 0; i<board.length; i++){
            for(int j =0; j<board[i].length; j++){
                if(board[i][j] == 'U'){
                    board[i][j] = 'O';
                }
            }
        }

    }
}
