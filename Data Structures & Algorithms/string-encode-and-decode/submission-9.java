class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(String str: strs) {
            encoded = encoded + str + "_____";
        }
        return encoded;
    }

    public List<String> decode(String str) {
        ArrayList<String> list = new ArrayList<>();
        String indi_str = "";
        for(int i = 0; i<str.length(); i++){
            if(str.substring(i, i+5<str.length()?i+5:str.length()).equals("_____")){
                list.add(indi_str);
                indi_str = "";
                i = i +4;
            } else {
                indi_str = indi_str + str.charAt(i);
            }
        }

        return list;
    }
}
