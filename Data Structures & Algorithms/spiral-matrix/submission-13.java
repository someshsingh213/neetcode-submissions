class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        boolean [][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        visited[i][j] = true;
                list.add(matrix[i][j]);
        while(list.size()<(matrix[0].length * matrix.length)){
                

                while(j+1 < matrix[0].length && !visited[i][j+1]){
                    j++;
                    visited[i][j] = true;
                list.add(matrix[i][j]);
                    
                }

                while(i+1 < matrix.length && !visited[i+1][j]){
                    i++;
                    visited[i][j] = true;
                list.add(matrix[i][j]);
                    
                }

                while(j-1>=0 && !visited[i][j-1]){
                    j--;
                    visited[i][j] = true;
                list.add(matrix[i][j]);
                    
                }

                while(i-1>=0 && !visited[i-1][j]){
                    i--;
                    visited[i][j] = true;
                list.add(matrix[i][j]);
                    
                }
        }

        return list;
    }
}
