class Solution {
    public int countSubstrings(String s) {
        int sum = 0;
        
        for( int i =0; i<s.length(); i++) {
            //odd
            int l = i;
            int r = i;

            while(l >= 0 && r < s.length()){
                if (s.charAt(l) == s.charAt(r)) {
                    sum++;
                    l--;
                r++;
                } else {
                    break;
                }
                
            }
        }

        for( int i =0; i<s.length() - 1; i++) {
            //odd
            int l = i;
            int r = i+1;

            while(l >= 0 && r < s.length()){
                if (s.charAt(l) == s.charAt(r)) {
                    sum++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }

        return sum;
    }
}
