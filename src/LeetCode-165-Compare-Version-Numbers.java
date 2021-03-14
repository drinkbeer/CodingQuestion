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
    
    // Another version
    public int compareVersion(String version1, String version2) {
        String[] stubs1 = version1.split("\\.");
        String[] stubs2 = version2.split("\\.");
        
        int i = 0, j = 0;
        while(i < stubs1.length && j < stubs2.length) {
            int comp = compareSubVersion(stubs1[i], stubs2[j]);
            if (comp != 0) return comp;
            
            i++;
            j++;
        }
        
        while (i < stubs1.length) {
            int comp = compareSubVersion(stubs1[i], "0");
            if (comp != 0) return comp;
            i++;
        }
        
        while (j < stubs2.length) {
            int comp = compareSubVersion("0", stubs2[j]);
            if (comp != 0) return comp;
            j++;
        }
        
        return 0;
    }
    
    public int compareSubVersion(String s1, String s2) {
        int v1 = Integer.valueOf(s1);
        int v2 = Integer.valueOf(s2);
        
        return Integer.compare(v1, v2);
    }
}
