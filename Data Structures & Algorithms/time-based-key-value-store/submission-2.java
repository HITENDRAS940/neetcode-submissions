class TimeMap {
    class Pair {
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(
            key, 
            k -> new ArrayList<>()
        ).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        String res = "";
        if(map.containsKey(key)) {
            ArrayList<Pair> pair = map.get(key);
            int low = 0;
            int high = pair.size() - 1;
            while(high>=low) {
                int mid = low + (high - low) / 2;
                if(pair.get(mid).timestamp == timestamp) {
                    return pair.get(mid).value;
                } else if(pair.get(mid).timestamp < timestamp ) {
                    res = pair.get(mid).value;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }           
        }
        
        return res;

    }
}
