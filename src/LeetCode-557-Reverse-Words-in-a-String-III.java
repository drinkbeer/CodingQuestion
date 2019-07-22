class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (!"".equals(strs[i])) {
                sb.append(strs[i]).append(" ");
            }
        }
        
        return sb.reverse().toString().trim();
    }
}
