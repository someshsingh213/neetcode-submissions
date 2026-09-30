class Twitter {

    HashMap<Integer, Set<Integer>> followMap;
    HashMap<Integer, List<int []>> postMap;
    PriorityQueue<int []> maxHeap;
    int count;

    public Twitter() {
        followMap = new HashMap<>();
        postMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(postMap.get(userId) == null){
            postMap.put(userId, new ArrayList<>());
        }
        count = count + 1;
        postMap.get(userId).add(new int [] {tweetId, count});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> listOfPosts = new ArrayList<>();

        Set<Integer> followeeIds = followMap.get(userId) == null ? new HashSet<>() : followMap.get(userId);
        followeeIds.add(userId);
        for(int followId : followeeIds){
            List<int []> posts = postMap.get(followId);
            if(posts == null || posts.size() == 0){
                continue;
            }
            int latestPost = posts.get(posts.size() - 1)[0];
            int timingOfLatestPost = posts.get(posts.size() - 1)[1];
            maxHeap.offer(new int [] {latestPost, timingOfLatestPost, followId, posts.size() - 1});
        }

        while(!maxHeap.isEmpty() && listOfPosts.size()<10){
            int [] latestPostArr = maxHeap.poll();
            int latestPost = latestPostArr[0];
            int followId = latestPostArr[2];
            int indexOfLatestPost = latestPostArr[3];
            listOfPosts.add(latestPost);
            if(indexOfLatestPost - 1 >= 0){
                List<int []> posts = postMap.get(followId);
                maxHeap.offer(new int [] {posts.get(indexOfLatestPost - 1)[0], posts.get(indexOfLatestPost - 1)[1], followId, indexOfLatestPost - 1});
            }
        }

        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        return listOfPosts;

    }
    
    public void follow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).add(followeeId);
        } else {
            followMap.put(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
