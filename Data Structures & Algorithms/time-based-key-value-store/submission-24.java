class TimeMap {
    HashMap<String, List<String []>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){

        } else {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new String [] {value, ""+timestamp}); //value, timestamp
    }
    
    public String get(String key, int timestamp) {
        List<String []> values = map.get(key);
        if(values == null){
            return "";
        }

        int r = values.size() - 1;
        int l = 0;
        int res = -1;
        while(r >= l) {
            int mid = l + (r-l)/2;
            if(Integer.parseInt(values.get(mid)[1]) == timestamp){
                return values.get(mid)[0];
            } else if (Integer.parseInt(values.get(mid)[1]) < timestamp){
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if(res == -1){
            return "";
        } else {
            return values.get(res)[0];
        }
    }
}
