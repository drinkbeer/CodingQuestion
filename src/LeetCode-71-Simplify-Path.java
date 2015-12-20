/*
LeetCode: https://leetcode.com/problems/simplify-path/
LintCode: http://www.lintcode.com/problem/simplify-path/
JiuZhang: http://www.jiuzhang.com/solutions/simplify-path/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-simplify-path-java/

Analysis:
First, split path by "/"
    If "." or "" or "/", do nothing and continue
    if "..", remove last string in list
    else, add into list
*/
public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() <= 1) return path;
        
        String result = "/";
        String[] stubs = path.split("/");
        List<String> list = new ArrayList<String>();
        
        for(String s : stubs){
            if(s.equals(".") || s.equals("") || s.equals("/")) continue;
            if(s.equals("..")){
                if(list.size() > 0) list.remove(list.size() - 1);
                continue;
            }
            list.add(s);
        }
        
        for(String s : list) result += s + "/";
        
        if(result.length() > 1) return result.substring(0, result.length() - 1);
        
        return result;
    }
    
}