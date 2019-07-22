class MyCalendar {

    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Map.Entry floorEntry = map.floorEntry(start);
        Map.Entry ceilingEntry = map.ceilingEntry(start);
        
        if (floorEntry != null && (int) floorEntry.getValue() > start) return false;
        if (ceilingEntry != null && (int) ceilingEntry.getKey() < end) return false;
        
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
