class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean [][] pacific = new boolean [heights.length][heights[0].length];
        boolean [][] atlantic = new boolean [heights.length][heights[0].length];
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int []> atlanticQ = new LinkedList<>();

        for(int i = 0; i<heights.length; i++){
            for(int j = 0; j<heights[i].length; j++){
                if(i == heights.length - 1 || j == heights[i].length - 1){
                    atlantic[i][j] = true;
                    atlanticQ.offer(new int[] {i, j});
                }
                if(i == 0 || j == 0){
                    pacific[i][j] = true;
                    pacificQ.offer(new int[] {i, j});
                }
            }
        }

        boolean [][] pacificVisited = new boolean [heights.length][heights[0].length];
        boolean [][] atlanticVisited = new boolean [heights.length][heights[0].length];
        
        while(!pacificQ.isEmpty()){
            int size = pacificQ.size();
            for(int k = 0; k<size; k++){
                int [] pair = pacificQ.poll();
                int i = pair[0];
                int j = pair[1];
                //up
                if(i-1 >= 0 && heights[i-1][j] >= heights[i][j] && !pacificVisited[i-1][j]){
                    pacific[i-1][j] = true;
                    pacificQ.offer(new int[]{i-1, j});
                }
                //right
                if(j+1 < heights[0].length && heights[i][j+1] >= heights[i][j] && !pacificVisited[i][j+1]){
                    pacific[i][j+1] = true;
                    pacificQ.offer(new int[]{i, j+1});
                }
                //down
                if(i+1 < heights.length && heights[i+1][j] >= heights[i][j] && !pacificVisited[i+1][j]){
                    pacific[i+1][j] = true;
                    pacificQ.offer(new int[]{i+1, j});
                }
                //left
                if(j-1 >= 0 && heights[i][j-1] >= heights[i][j] && !pacificVisited[i][j-1]){
                    pacific[i][j-1] = true;
                    pacificQ.offer(new int[]{i, j-1});
                }
                pacificVisited[i][j] = true;
            }
        }


                while(!atlanticQ.isEmpty()){
            int size = atlanticQ.size();
            for(int k = 0; k<size; k++){
                int [] pair = atlanticQ.poll();
                int i = pair[0];
                int j = pair[1];
                //up
                if(i-1 >= 0 && heights[i-1][j] >= heights[i][j] && !atlanticVisited[i-1][j]){
                    atlantic[i-1][j] = true;
                    atlanticQ.offer(new int[]{i-1, j});
                }
                //right
                if(j+1 < heights[0].length && heights[i][j+1] >= heights[i][j] && !atlanticVisited[i][j+1]){
                    atlantic[i][j+1] = true;
                    atlanticQ.offer(new int[]{i, j+1});
                }
                //down
                if(i+1 < heights.length && heights[i+1][j] >= heights[i][j] && !atlanticVisited[i+1][j]){
                    atlantic[i+1][j] = true;
                    atlanticQ.offer(new int[]{i+1, j});
                }
                //left
                if(j-1 >= 0 && heights[i][j-1] >= heights[i][j] && !atlanticVisited[i][j-1]){
                    atlantic[i][j-1] = true;
                    atlanticQ.offer(new int[]{i, j-1});
                }
                atlanticVisited[i][j] = true;
            }
        }

        for(int i = 0; i<heights.length; i++){
            for(int j = 0; j<heights[i].length; j++){
                if(atlantic[i][j] && pacific[i][j]){
                    List<Integer> rowCol = new ArrayList<>();
                    rowCol.add(i);
                    rowCol.add(j);
                    res.add(rowCol);
                }
            }
        }

        return res;

    }
}
