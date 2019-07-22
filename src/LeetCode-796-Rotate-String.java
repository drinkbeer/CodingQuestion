class Solution {
    /*
    https://leetcode.com/problems/rotate-string/discuss/118696/C%2B%2B-Java-Python-1-Line-Solution
    */
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
