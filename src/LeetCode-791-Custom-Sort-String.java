class Solution {
    // Count and Sort
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            for (int i = 0; i < freq[ch - 'a']; i++) {
                sb.append(ch);
            }
            freq[ch - 'a'] = 0;
        }
        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                sb.append((char)('a' + i));
            }
            freq[i] = 0;
        }
        
        return sb.toString();
    }
}
