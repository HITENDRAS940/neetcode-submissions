class TimeMap {
    class Pair {
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, HashMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(
            key, 
            k -> new HashMap<>()
        ).putIfAbsent(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            HashMap<Integer, String> m = map.get(key);
            int i = timestamp;
            while(m.size()>0 && i>-1) {
                if(m.containsKey(i)) {
                    return m.get(i);
                } else {
                    i--;
                }
            }
        }
        
        return "";

    }
}
