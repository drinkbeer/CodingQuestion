/*
LeetCode:  https://leetcode.com/problems/compare-version-numbers/
LintCode:  not find
JiuZhang:  not find
ProgramCreek:  http://www.programcreek.com/2014/03/leetcode-compare-version-numbers-java/

Analysis:  
Must understand split("\\."), not split(".")
Besides, 1.0 and 1 are the same
*/
public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2)) return 0;
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = Math.max(v1.length, v2.length);
        for(int i = 0; i < len; i++){
            int i1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int i2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;
            if(i1 > i2) return 1;
            if(i1 < i2) return -1;
        }
        return 0;
    }
}