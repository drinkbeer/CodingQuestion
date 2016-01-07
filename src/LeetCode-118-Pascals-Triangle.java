/*
LeetCode: https://leetcode.com/problems/pascals-triangle/
LintCode: http://www.lintcode.com/problem/pascals-triangle/
JiuZhang: http://www.jiuzhang.com/solutions/pascals-triangle/
ProgramCreek: http://www.programcreek.com/2014/03/leetcode-pascals-triangle-java/

Analysis:

*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows<1){
            return res;
        }
        
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        res.add(pre);
        for(int i = 1;i<numRows;i++){
            List<Integer> cur = new ArrayList<Integer>();
            
            cur.add(1);
            for(int j = 0;j<pre.size()-1;j++){
                cur.add(pre.get(j)+pre.get(j+1));
            }
            cur.add(1);
            
            res.add(cur);
            
            pre=cur;
            cur=new ArrayList<Integer>();
        }
        return res;
    }
}