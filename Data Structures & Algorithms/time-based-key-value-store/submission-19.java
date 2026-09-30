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
        
        int l = 0;
        int r = listOfTimeStamps.size() - 1;

        int index = -1;
        while(r >= l) {
            int mid = l + (r-l)/2;
            if(Integer.parseInt(listOfTimeStamps.get(mid)[0]) == timestamp){
                index = mid;
                break;
            } else if (Integer.parseInt(listOfTimeStamps.get(mid)[0]) < timestamp){
                index = mid;
                l = mid + 1;
            }
             else {
                r = mid - 1;
            }
        }

        return index == -1 ? "": listOfTimeStamps.get(index)[1];
}

}
