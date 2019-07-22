class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String str : emails) {
            boolean atSeen = false;
            boolean plusSeen = false;
            StringBuilder sb = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (atSeen) {
                    sb.append(c);
                } else {
                    if (plusSeen && '@' != c) {
                        continue;
                    }
                    
                    if ('@' == c) {
                        atSeen = true;
                        sb.append(c);
                    }
                    
                    if ('+' == c) {
                        plusSeen = true;
                    } else if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                        sb.append(c);
                    }
                }
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
