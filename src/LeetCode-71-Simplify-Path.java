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
    // 1.Using List
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
    
    // 2.Using stack
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : strs) {
            if (str.length() > 0) stack.push(str);
        }
        
        String result = "";
        int back = 0;
        while (!stack.isEmpty()) {
            String str = stack.pop();
            if (".".equals(str)) {
                continue;
            } else if ("..".equals(str)) {
                back++;
            } else {
                if (back > 0) {
                    back--;
                } else {
                    result = "/" + str + result;
                }
            }
        }
        return result.length() == 0 ? "/" : result;
    }
    
    // 3.
    // https://leetcode.com/problems/simplify-path/discuss/25686/Java-10-lines-solution-with-stack
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
    
}
