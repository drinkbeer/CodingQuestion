class Solution {
    // 1. Wrong Answer
    // public boolean canConstruct(String ransomNote, String magazine) {
    //     return magazine.indexOf(ransomNote) != -1;
    // }
    
    // 1. Two Pointers
    /*
    Time: O(M + N)
    Space: O(26)
    */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mask = new int[26];
        for (char c : magazine.toCharArray()) {
            mask[c - 'a']++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            mask[c - 'a']--;
            if (mask[c - 'a'] < 0) return false;
        }
        
        return true;
    }
}
