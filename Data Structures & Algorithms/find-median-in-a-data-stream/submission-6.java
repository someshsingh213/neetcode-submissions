class MedianFinder {
    List<Double> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num*1.0);
        
    }
    
    public double findMedian() {
Collections.sort(list);

        if(list.size() == 1){
            return list.get(0);
        }
        if(list.size()%2 == 1){
            return list.get(list.size()/2);
        } else {
            return (list.get(list.size()/2) + list.get((list.size()/2) - 1))/2;
        }
    }
}
