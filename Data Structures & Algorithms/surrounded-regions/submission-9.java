class Solution {
    public void solve(char[][] board) {
        //convert any edge 0s to T and also add them to the queue to run BFS
        Queue<int []> queue = new LinkedList<>();
        int [][] directions = new int [][] {
            {-1, 0}, {0, 1}, {1, 0}, {0,-1}
        };
        for(int i = 0; i<board.length; i++) {
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

            // here
            for(int [] direction: directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if(newRow >= 0 && newCol >=0 && newRow < board.length && newCol < board[0].length
                && !visit.contains(new int [] {newRow, newCol}) && board[newRow][newCol] == 'O'){
                    board[newRow][newCol] = 'U';
                    queue.offer(new int [] {newRow, newCol});
                }
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
