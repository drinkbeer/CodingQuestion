/*
LeetCode: https://leetcode.com/problems/roman-to-integer/
LintCode: http://www.lintcode.com/problem/roman-to-integer/
JiuZhang: http://www.jiuzhang.com/solutions/roman-to-integer/
ProgramCreek: not find
Other: http://blog.csdn.net/wzy_1988/article/details/17057929

Analysis: 
计数规则：
相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
正常使用时，连续的数字重复不得超过三次
在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）

其次，罗马数字转阿拉伯数字规则（仅限于3999以内）：

从前向后遍历罗马数字，如果某个数比前一个数小，则加上该数。反之，减去前一个数的两倍然后加上该数

找下subtractive notation的规律，以简单的例子s = IX 说明。
    1. 如果按照additive性质的话应该ret = 1+10 = 11。但因为num(X)=10>num(I)=1，ret = 10 - 1。
    2. 将subtractive rule转换成等效的additive rule：ret = 1 + (10 - 2*1)

2.scan from left to right
建立一个罗马字符对应整数的hash table ht。
当ht[s[i]] > ht[s[i-1]]，即为subtractive nontation：ret += (ht[s[i]] - 2*ht[s[i-1]])
否则为additive nontation：ret+=ht[s[i]]
*/

public class Solution {
    // 1.scan from right to left
    // public int romanToInt(String s) {
    //     HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    //     map.put('M', 1000);
    //     map.put('D', 500);
    //     map.put('C', 100);
    //     map.put('L', 50);
    //     map.put('X', 10);
    //     map.put('V', 5);
    //     map.put('I', 1);
        
    //     int len = s.length();
        
    //     int result = map.get(s.charAt(len - 1));
    //     for(int i = len - 2; i >= 0; i--){
    //         if(map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))){
    //             result += map.get(s.charAt(i));
    //         }else{
    //             result -= map.get(s.charAt(i));
    //         }
    //     }
        
    //     return result;
    // }
    
    // scan from left to right
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        
        int len = s.length();
        
        int result = map.get(s.charAt(0));
        for(int i = 1; i < len; i++){
            if(map.get(s.charAt(i)) > map.get(s.charAt(i - 1))){
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            }else{
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }
}