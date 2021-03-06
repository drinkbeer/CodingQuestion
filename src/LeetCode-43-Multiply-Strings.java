/*
LeetCode: https://leetcode.com/problems/multiply-strings/
LintCode: http://www.lintcode.com/problem/multiply-strings/
JiuZhang: http://www.jiuzhang.com/solutions/multiply-strings/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-multiply-strings-java/
Other: https://leetcodenotes.wordpress.com/2013/10/20/leetcode-multiply-strings-%E5%A4%A7%E6%95%B4%E6%95%B0%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%98%E6%B3%95/

Analysis: 

*/
public class Solution {
    // 直接乘会溢出，所以每次都要两个single digit相乘，最大81，不会溢出。
    // 比如385 * 97, 就是个位=5 * 7，十位=8 * 7 + 5 * 9 ，百位=3 * 7 + 8 * 9 …
    // 可以每一位用一个Int表示，存在一个int[]里面。
    // 这个数组最大长度是num1.len + num2.len，比如99 * 99，最大不会超过10000，所以4位就够了。
    // 这种个位在后面的，不好做（10的0次方，可惜对应位的数组index不是0而是n-1），
    // 所以干脆先把string reverse了代码就清晰好多。
    // 最后结果前面的0要清掉。
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        int[] nums = new int[num1.length() + num2.length()];
        for(int i = 0; i < num1.length(); i++){
            int a = num1.charAt(i) - '0';
            for(int j = 0; j < num2.length(); j++){
                int b = num2.charAt(j) - '0';
                nums[i + j] += a * b;
            }
        }
        
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for(int i = 0; i < nums.length; i++){
            int digit = (nums[i] + carry) % 10;
            carry = (nums[i] + carry) / 10;
            sb.insert(0, digit);
        }
        
        if(carry != 0) sb.insert(0, carry);
        while(sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
    // 2.
    /*
    https://www.cnblogs.com/grandyang/p/4395356.html
    https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
    */
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int p1 = i + j, p2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + result[p2];
                result[p2] = mul % 10;
                result[p1] += mul / 10;
            }
        }
        
        int i = 0;
        for (; i < result.length; i++) {
            if (result[i] != 0) break;
        }
        if (i == result.length) return "0";
        
        String res = "";
        for (; i < result.length; i++) {
            res += result[i];
        }
        return res;
    }
}
