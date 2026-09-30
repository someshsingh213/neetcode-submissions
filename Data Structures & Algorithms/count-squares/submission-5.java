class CountSquares {

    Map<String, Integer> map;
    public CountSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        if(!map.containsKey(key)){
            map.put(key, 0);
        }
        map.put(key, map.get(key) + 1);
    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];

        int res = 0;
        for(String str: map.keySet()) {
            String [] p = str.split(",");
            int x = Integer.parseInt(p[0]);
            int y = Integer.parseInt(p[1]);

            if((Math.abs(px - x) == Math.abs(py - y)) && px!=x && py!=y){
                res = res + map.get(x+","+y)*(map.getOrDefault(px + "," + y, 0) * map.getOrDefault(x + "," + py, 0));
            }
        }

        return res;
    }
}
