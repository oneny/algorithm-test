class MyHashMap {
    
    static final int BUCKET_CAPACITY = 100;
    static LinkedList<Node>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[10001];
    }
    
    public void put(int key, int value) {
        int index = key / BUCKET_CAPACITY;
        
        LinkedList<Node> bucket = buckets[index];
        if (bucket == null) {
            buckets[index] = new LinkedList<>();
            buckets[index].addLast(new Node(key, value));
        } else {
            Integer findIndex = bucket.indexOf(new Node(key, value));
            
            if (findIndex == -1) {
                bucket.addLast(new Node(key, value));
                return;
            }
            
            bucket.remove(new Node(key, value));
            bucket.addLast(new Node(key, value));
        }
    }
    
    public int get(int key) {
        int index = key / BUCKET_CAPACITY;
        
        LinkedList<Node> bucket = buckets[index];
        
        if (bucket == null) {
            return -1;
        }
        
        int findIndex = bucket.indexOf(new Node(key, null));
        
        if (findIndex != -1) {
            return bucket.get(findIndex).value;
        }
        
        return findIndex;
    }
    
    public void remove(int key) {
        int index = key / BUCKET_CAPACITY;
        
        LinkedList<Node> bucket = buckets[index];
        
        if (bucket == null) {
            return;
        }
        
        int findIndex = bucket.indexOf(new Node(key, null));
        
        if (findIndex == -1) {
            return;
        }
        
        bucket.remove(new Node(key, null));
    }
    
    class Node {
        Integer key;
        Integer value;
        
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
        
        @Override
        public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Node node = (Node) o;
          return Objects.equals(key, node.key);
        }

        @Override
        public int hashCode() {
          return Objects.hash(key);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */