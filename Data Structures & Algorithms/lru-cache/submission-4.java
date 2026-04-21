class LRUCache {

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    private class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);

        node.prev.next = node.next;
        node.next.prev = node.prev;

        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;

        return node.value;      
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            get(key);
            return;
        }

        if (map.size() == this.capacity) {
            Node lru = head.next;
            head.next = lru.next;
            lru.next.prev = head;
            map.remove(lru.key);
        }
        Node node = new Node(key, value);
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
        map.put(key, node);        
    }
}
