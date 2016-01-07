/*
LeetCode: https://leetcode.com/problems/pascals-triangle-ii/
LintCode: http://www.lintcode.com/problem/pascals-triangle-ii/
JiuZhang: http://www.jiuzhang.com/solutions/pascals-triangle-ii/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-pascals-triangle-ii-java/

Analysis: 

*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(rowIndex < 0) return result;
        
        result.add(1);
        
        for(int i = 1; i <= rowIndex; i++){
            result.add(1);
            for(int j = 0; j < i - 1; j++){
                result.add(result.get(0) + result.get(1));
                result.remove(0);
            }
            result.remove(0);
            result.add(1);
        }
        
        return result;
    }
}