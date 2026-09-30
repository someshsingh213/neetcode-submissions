class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //find the row that has the item

        int top = 0;
        int bottom = matrix.length - 1;
        int selectedRow = 0;
        int mid = 0;
        while(top <= bottom){
            mid = (top + (bottom - top)/2);
            if(target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]){
                selectedRow = mid;
                break;
            } else if(target > matrix[mid][matrix[mid].length - 1]){
                top = mid + 1;
            } else if(target < matrix[mid][0]){
                bottom = mid - 1;
            }
        }

        int left = 0;
        int right = matrix[selectedRow].length - 1;
        while(left <= right) {
            mid = (left + (right - left ) / 2);
            if(target > matrix[selectedRow][mid]){
                left = mid + 1;
            } else if (target < matrix[selectedRow][mid]){
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
