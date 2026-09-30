class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(String str: strs) {
            encoded = encoded + str.length() + "#" + str;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        ArrayList<String> list = new ArrayList<>();
        String len = "";
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i)!='#'){
                len = len+str.charAt(i);
            } else {
                int len1 = Integer.parseInt(len);
                list.add(str.substring(i+1,i+1+len1));
                i=i+len1;
                len ="";
            }
        }
        return list;
    }
}
