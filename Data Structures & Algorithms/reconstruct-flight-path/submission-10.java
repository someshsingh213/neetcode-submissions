class Solution {
    List<String> sol;
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((a, b) -> {
            int cmp = a.get(0).compareTo(b.get(0));
            if (cmp != 0) return cmp;
            return a.get(1).compareTo(b.get(1));
        });

        HashMap<String, Deque<String>> adjacencyList = new HashMap<>();

        for(List<String> pair : tickets){
            String departure = pair.get(0);
            String arrival = pair.get(1);
            if(adjacencyList.get(departure) != null) {
                
            } else {
                adjacencyList.put(departure, new LinkedList<>());
            }
            adjacencyList.get(departure).addLast(arrival);
        }

        sol = new ArrayList<>();
        //sol.add("JFK");
        dfs("JFK", adjacencyList);
        return sol;
    }

    private void dfs(String from, Map<String, Deque<String>> graph) {
        Deque<String> dests = graph.get(from);
        while (dests != null && !dests.isEmpty()) {
            String next = dests.pollFirst();
            dfs(next, graph);
        }
        // add in post-order so path is reversed
        sol.add(0, from);
    }
}
