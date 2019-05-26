/*
http://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/


星号：asterisk
点号：dot

https://www.cnblogs.com/grandyang/p/4461713.html
1.Backtracking
For this difficult problem, it's hard to think throughly of all the cases. The problem can be simplified to 2 cases:

这道求正则表达式匹配的题和那道 Wildcard Matching 的题很类似，不同点在于*的意义不同，在之前那道题中，*表示可以代替任意个数的字符，而这道题中的*表示之前那个字符可以有0个，1个或是多个，就是说，字符串a*b，可以表示b或是aaab，即a的个数任意，这道题的难度要相对之前那一道大一些，分的情况的要复杂一些，需要用递归Recursion来解，大概思路如下：

- 若p为空，若s也为空，返回true，反之返回false。

- 若p的长度为1，若s长度也为1，且相同或是p为'.'则返回true，反之返回false。

- 若p的第二个字符不为*，若此时s为空返回false，否则判断首字符是否匹配，且从各自的第二个字符开始调用递归函数匹配。

- 若p的第二个字符为*，进行下列循环，条件是若s不为空且首字符匹配（包括p[0]为点），调用递归函数匹配s和去掉前两个字符的p（这样做的原因是假设此时的星号的作用是让前面的字符出现0次，验证是否匹配），若匹配返回true，否则s去掉首字母（因为此时首字母匹配了，我们可以去掉s的首字母，而p由于星号的作用，可以有任意个首字母，所以不需要去掉），继续进行循环。

- 返回调用递归函数匹配s和去掉前两个字符的p的结果（这么做的原因是处理星号无法匹配的内容，比如s="ab", p="a*b"，直接进入while循环后，我们发现"ab"和"b"不匹配，所以s变成"b"，那么此时跳出循环后，就到最后的return来比较"b"和"b"了，返回true。再举个例子，比如s="", p="a*"，由于s为空，不会进入任何的if和while，只能到最后的return来比较了，返回true，正确）。
    
2.DP
https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation
https://leetcode.com/problems/regular-expression-matching/discuss/191830/Java-DP-solution-beats-100-with-explanation
There is one hidden assumption of the problem: the first one cannot be "*".

1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*': 
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty

3.DP
O(N) space
https://discuss.leetcode.com/topic/55714/5ms-java-dp-and-o-n-space-solution
*/
public class Solution {
    // 1.Recursive
//     public boolean isMatch(String s, String p) {
//         if(s == null || p == null) return false;
//         if (p.length() == 0) return s.length() == 0;
        
//         if (p.length() == 1) {
//             return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
//         }
        
//         if (p.charAt(1) != '*') {
//             if (s.length() == 0) return false;
//             return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
//         }
        
//         // p.charAt(1) == '*'
//         while (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
//             if (isMatch(s, p.substring(2))) return true;
//             s = s.substring(1);
//         }
//         return isMatch(s, p.substring(2));
//     }
    
    // 2. DP
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for(int j = 0; j < p.length(); j++){
            if(p.charAt(j) == '*' && dp[0][j - 1]) dp[0][j + 1] = true;
        }
        
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < p.length(); j++){
                if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) dp[i + 1][j + 1] = dp[i][j];
                
                if(p.charAt(j) == '*'){
                    if(p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i)) dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    else dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i + 1][j - 1] || dp[i][j + 1]);
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }

}
