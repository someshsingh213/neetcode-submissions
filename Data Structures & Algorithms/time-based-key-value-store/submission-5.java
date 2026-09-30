class TimeMap {
    HashMap<String, List<String []>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) { //O(1)
        if(map.get(key)!=null) {
            
        } 
        else {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new String [] {timestamp + "", value});
    }
    
    public String get(String key, int timestamp) {
        if(map.get(key) == null){
            return "";
        } 
        List<String [] > listOfTimeStamps = map.get(key);

        if(listOfTimeStamps.size() == 0){
            return "";
        }
        
        int ret = 0;
        int index = -1;
        for(int i = 0; i < listOfTimeStamps.size(); i++){
            int checkTimeStamp = Integer.parseInt(listOfTimeStamps.get(i)[0]);
            if(checkTimeStamp == timestamp){
                ret = checkTimeStamp;
                index = i;
                break;
            } else {
                if(checkTimeStamp < timestamp){
                    ret = checkTimeStamp;
                    index = i;
                }
            }
            
    }

    if(index == -1){
        return "";
    } else {
        return listOfTimeStamps.get(index)[1];
    }
}
}
