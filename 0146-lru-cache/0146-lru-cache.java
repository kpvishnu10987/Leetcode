class LRUCache {
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer,Node> map;
    Node head;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        add(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);

            remove(node);
            node.val = value;
            add(node);
            map.put(key,node);
        }else{
            Node node = new Node(key,value);
            add(node);
            map.put(key,node);
            if(map.size() > cap){
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }

    void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    void add(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */