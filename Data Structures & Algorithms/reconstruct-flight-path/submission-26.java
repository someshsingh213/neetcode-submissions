class Solution {
    List<String> res;
    List<List<String>> tickets;
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((a, b) -> {
    int cmp = a.get(0).compareTo(b.get(0));
    if (cmp != 0) return cmp;
    return a.get(1).compareTo(b.get(1));
});
this.tickets = tickets;
//arrival - destinations
HashMap<String, Deque<String>> adjacencyList = new HashMap<>();
for(int i = 0; i<tickets.size(); i++){
    List<String> pair = tickets.get(i);
    String arrival = pair.get(0);
    String departure = pair.get(1);
    if(adjacencyList.containsKey(arrival)){
        
    } else {
        adjacencyList.put(arrival, new LinkedList<>());
    }
    adjacencyList.get(arrival).addLast(departure);
}

res = new ArrayList<>();
res.addLast("JFK");
dfs("JFK", adjacencyList);
return res;
    }

    boolean dfs(String arrival, HashMap<String, Deque<String>> adjacencyList) {
        if(res.size() == tickets.size() + 1) {
            return true;
        }

        if(adjacencyList.get(arrival)==null || adjacencyList.get(arrival).isEmpty()){
            return false;
        }

        for(int i = 0; i<adjacencyList.get(arrival).size(); i++){
            String city = adjacencyList.get(arrival).pollFirst();
            res.addLast(city);
            if(dfs(city, adjacencyList)){
                return true;
            } else {
                res.removeLast();
                adjacencyList.get(arrival).addLast(city);
            }
        }
        return false;
    }
}
