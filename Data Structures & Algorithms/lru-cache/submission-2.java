class LRUCache {

    Map<Integer, Integer> map;
    LinkedHashSet<Integer> set;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        set = new LinkedHashSet<>();
        size = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            if(set.contains(key)) {
                set.remove(key);
                set.add(key);
            }
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            set.remove(key);
        }
        map.put(key, value);
        set.add(key);
        if(map.size() > size) {
            int first = set.iterator().next();
            map.remove(first);
            set.remove(first);
        }
        
    }
}
