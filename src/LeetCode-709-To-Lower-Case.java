class Solution {
    public String toLowerCase(String str) {
        int offset = 'A' - 'a';
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c - offset));
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
