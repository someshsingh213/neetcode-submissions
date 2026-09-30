class Solution {
        List<String> res;
            HashMap<String, PriorityQueue<String>> adjacencyList;
                public List<String> findItinerary(List<List<String>> tickets) {
                        tickets.sort((a, b) -> {
                            int cmp = a.get(0).compareTo(b.get(0));
                                if (cmp != 0) return cmp;
                                    return a.get(1).compareTo(b.get(1));
                                    });

                                    adjacencyList = new HashMap<>();

                                    for(int i = 0; i<tickets.size(); i++){
                                        if(adjacencyList.containsKey(tickets.get(i).get(0))){
                                        } else {
                                            adjacencyList.put(tickets.get(i).get(0), new PriorityQueue<>());
                                        }
                                        adjacencyList.get(tickets.get(i).get(0)).offer(tickets.get(i).get(1));
                                        }

                                        res = new ArrayList<>();
                                        dfs("JFK");
                                        Collections.reverse(res);
                                        return res;
                                            }

                                                void dfs(String airport){
                                                        while(adjacencyList.get(airport)!=null && !adjacencyList.get(airport).isEmpty()){
                                                                    dfs(adjacencyList.get(airport).poll());
                                                                            }
                                                                                    res.add(airport);
                                                                                        }
                                                                                        }

