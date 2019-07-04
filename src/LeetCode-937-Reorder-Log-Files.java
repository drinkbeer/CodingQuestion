class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        /*
        https://leetcode.com/problems/reorder-log-files/discuss/193872/Java-Nothing-Fancy-15-lines-5ms-all-clear.
        
        
        The compare return value:
        1 - swap c1 and c2
        -1 - don't swap c1 and c2
        0 - do nothing
        
        */
        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String s1, String s2) {
                String[] strs1 = s1.split(" ");
                String[] strs2 = s2.split(" ");
                
                char c1 = strs1[1].charAt(0);
                char c2 = strs2[1].charAt(0);
                
                if (c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9') return 0;
                if (c1 >= '0' && c1 <= '9' && c2 >= 'a' && c2 <= 'z') return 1;
                if (c1 >= 'a' && c1 <= 'z' && c2 >= '0' && c2 <= '9') return -1;
                
                int preComputed = s1.substring(s1.indexOf(" ") + 1).compareTo(s2.substring(s2.indexOf(" ") + 1));
                if (preComputed == 0) return s1.substring(0, s1.indexOf(" ")).compareTo(s2.substring(0, s2.indexOf(" ")));
                return preComputed;
            }
        };
        
        Arrays.sort(logs, comparator);
        return logs;
    }
}
