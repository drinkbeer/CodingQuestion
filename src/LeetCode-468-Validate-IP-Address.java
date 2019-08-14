class Solution {
    public String validIPAddress(String IP) {
        if (IP.startsWith(".") || IP.endsWith(".") || IP.startsWith(":") || IP.endsWith(":")) return "Neither";
        
        boolean isIPv4 = true;
        String[] strs;
        if (IP.contains(":")) {
            strs = IP.split("\\:");
            isIPv4 = false;
        } else if (IP.contains(".")) {
            strs = IP.split("\\.");
        } else {
            return "Neither";
        }
        
        // System.out.println("isIPv4: " + isIPv4 + "  strs: " + Arrays.toString(strs));
        if (isIPv4 && strs.length != 4) {
            return "Neither";
        } else if (!isIPv4 && strs.length != 8) {
            return "Neither";
        }
        
        for (String s : strs) {
            if (isIPv4) {
                if (!isValidIPv4(s)) return "Neither";
            } else {
                if (!isValidIPv6(s)) return "Neither";
            }
        }
        return isIPv4 ? "IPv4" : "IPv6";
    }
    
    private boolean isValidIPv4(String s) {
        if (s == null || s.length() == 0 || s.length() > 3) return false;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && c == '0') return s.equals("0");
            if (c < '0' || c > '9') return false;
            num = 10 * num + c - '0';
        }
         
        return num >= 0 && num <= 255;
    }
    
    private boolean isValidIPv6(String s) {
        if (s == null || s.length() == 0 || s.length() > 4) return false;
        for (char c : s.toCharArray()) {
            if (!(c >= '0' && c <= '9') && !(c >= 'A' && c <= 'F') && !(c >= 'a' && c <= 'f')) {
                return false;
            }
        }
        return true;
    }
}
