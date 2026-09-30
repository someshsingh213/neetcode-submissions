class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public Node (int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node lru;
    Node mru;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        lru = new Node(-1, -1);
        mru = new Node(-2, -2);
        lru.next = mru;
        mru.prev = lru;
    }
    
    public void addNode(int key, Node node){
        Node next = mru;
        Node prev = mru.prev;
        prev.next = node;
        node.next = mru;
        mru.prev = node;
        node.prev= prev;
    }

    public Node removeNode(){
        Node next = lru.next.next;
        Node toBeRemoved = lru.next;
        Node prev = lru;
        prev.next = next;
        next.prev = prev;
        return toBeRemoved;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            addNode(key, node); 
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        Node newNode = new Node(key, value);
        addNode(key, newNode);
        map.put(key, newNode);
        if(map.keySet().size() > capacity){
            map.remove(removeNode().key);
        }
        
    }
}
