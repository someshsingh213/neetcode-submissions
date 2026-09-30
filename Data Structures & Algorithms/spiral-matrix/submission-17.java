class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> list = new ArrayList<>();

        while(top<=bottom && left<=right){
            for(int j = left; j<=right; j++){
                list.add(matrix[top][j]);
            }
            top++;
            if(top>bottom){
                break;
            }
            
            for(int i = top; i<=bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(right<left){
                break;
            }

            for(int i = right; i>=left; i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if(top>bottom){
                break;
            }

            for(int i = bottom; i>=top; i--){
                list.add(matrix[i][left]);
            }
            left++;
            if(right<left){
                break;
            }

        }
        return list;
    }
}
