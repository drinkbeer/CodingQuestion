class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        
        for (String str : words) {
            if (str.length() != pattern.length()) continue;
            
            int[] m1 = new int[26];
            int[] m2 = new int[26];
            Arrays.fill(m1, -1);
            Arrays.fill(m2, -1);
            
            for (int i = 0; i < str.length(); i++) {
                char c1 = str.charAt(i);
                char c2 = pattern.charAt(i);
                
                if (m1[c1 - 'a'] != m2[c2 - 'a']) {
                    break;
                }
                
                if (m1[c1 - 'a'] == -1 && m2[c2 - 'a'] == -1) {
                    m1[c1 - 'a'] = i;
                    m2[c2 - 'a'] = i;
                }
                
                if (i == str.length() - 1) {
                    res.add(str);
                }
            }
            
        }
        
        return res;
    }
}
