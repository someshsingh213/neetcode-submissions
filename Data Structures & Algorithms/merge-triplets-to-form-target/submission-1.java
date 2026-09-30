class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean [] possible = new boolean[3];
        for(int i = 0; i<triplets.length; i++) {
            int [] triplet = triplets[i];
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]){
                continue;
            }

            if(triplet[0] == target[0]){
                possible[0] = true;
            }

            if(triplet[1] == target[1]){
                possible[1] = true;
            }

            if(triplet[2] == target[2]){
                possible[2] = true;
            }
        }

        for(int i = 0; i<3; i++){
        if(possible[i] == false){
            return false;
        }
    }

    return true;
    }

    
}
