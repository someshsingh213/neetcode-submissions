class Solution {
    public void rotate(int[][] matrix) {
        /*
        0,0 -> 0,2 
        0,1 -> 1,2
        0,2 -> 2,2
        1,0 -> 0,1
        1,1 -> 1,1
        1,2 -> 2,1
        2,0 -> 0,0
        2,1 -> 1,0
        2,2 -> 2,0
        Run a loop throughout the matrix
        set newMatrix[j][matrix[i].length - 1 - i] = matrix[i][j]
        */


        /*
        90 degree rotation means:
            ith row becomes n - 1 - ith column

        What transpose does:
            ith row becomes ith column
        Reverse columns:
            ith column becomes n - 1 - ith column
        Transposing and reversing together:
            ith row becomes n - 1 - ith column

        1 2      
        3 4

         3 1
         4 2
        */


        for (int i = 0; i<matrix.length; i++) {
            for(int j = i; j<matrix[i].length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length/2; j++) {
                int temp = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // for (int i = 0; i<matrix.length; i++){
        //     for(int j = 0; j<matrix[i].length; j++){
        //         matrix[i][matrix[i].length-1-j] = matrix[i][j];
        //     }
        // }        
    }
}
