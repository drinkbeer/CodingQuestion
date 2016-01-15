/*
LeetCode: https://leetcode.com/problems/permutation-sequence/
LintCode: http://www.lintcode.com/problem/permutation-sequence/
JiuZhang: http://www.jiuzhang.com/solutions/permutation-sequence/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-permutation-sequence-java/
Other: http://blog.sina.com.cn/s/blog_eb52001d0102v1ss.html

Analysis:
1.DFS, TLE

2.Math
有没有什么方法不是逐个求，而是直接构造出第k个排列呢？我们以n = 4，k = 17为例，数组src = [1,2,3,...,n]。

第17个排列的第一个数是什么呢：我们知道以某个数固定开头的排列个数 = (n-1)! = 3! = 6, 即以1和2开头的排列总共6*2 = 12个，12 < 17, 因此第17个排列的第一个数不可能是1或者2，6*3 > 17, 因此第17个排列的第一个数是3。即第17个排列的第一个数是原数组（原数组递增有序）的第m = upper(17/6) = 3（upper表示向上取整）个数。
第一个数固定后，我们从src数组中删除该数，那么就相当于在当前src的基础上求第k - (m-1)*(n-1)! = 17 - 2*6 = 5个排列，因此可以递归的求解该问题。

1. 以某一数字开头的排列有(n-1)! 个。
例如： 123， 132， 以1开头的是 2！个
2. 所以第一位数字就可以用 （k-1）/(n-1)!  来确定.这里K-1的原因是，序列号我们应从0开始计算，否则在边界时无法计算。
3. 第二位数字。假设前面取余后为m，则第二位数字是 第 m/(n-2)! 个未使用的数字。
4. 不断重复2，3，取余并且对(n-k)!进行除法，直至计算完毕
*/

public class Solution {
    // 1.DFS
    // Time Limit Exceed
    // public String getPermutation(int n, int k) {
    //     if(n <= 1) return n + "";
        
    //     List<String> res = new ArrayList<String>();
        
    //     List<Integer> list = new ArrayList<Integer>();
    //     DFS(n, res, list);
        
    //     return res.get(k - 1);  //Be careful, K starts from 1
    // }
    
    // private void DFS(int n, List<String> result, List<Integer> list){
    //     //end condition
    //     if(n == list.size()){
    //         StringBuilder sb = new StringBuilder();
    //         for(int i = 0; i < list.size(); i++){
    //             sb.append(list.get(i));
    //         }
    //         result.add(sb.toString());
    //     }
        
    //     for(int i = 1; i <= n; i++){
    //         if(!list.contains(i)){
    //             list.add(i);
    //             DFS(n, result, list);
    //             list.remove(list.size() - 1);
    //         }
    //     }
    // }
    
    // 2.Math
    // public String getPermutation(int n, int k) {
    //     if(n <= 1) return n + "";
        
    //     StringBuilder sb = new StringBuilder();
    //     int factor = 1;
    //     List<Integer> nums = new ArrayList<Integer>();
    //     for(int i = 1; i <= n; i++){
    //         factor *= n;
    //         nums.add(i);
    //     }
    //     factor /= n;
    //     k--;
        
    //     for(int i = n - 1; i >= 1; i--){
    //         int pos = k / factor;
    //         sb.append(nums.get(pos));
    //         nums.remove(pos);
    //         k %= factor;
    //         factor /= i;
    //     }
    //     sb.append(nums.get(0));
    //     return sb.toString();
    // }
    
    
    public String getPermutation(int n, int k) {
 
        // initialize all numbers
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            numberList.add(i);
        }
 
        // change k to be index
        k--;
 
        // set factorial of n
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod = mod * i;
        }
 
        String result = "";
 
        // find sequence
        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            // find the right number(curIndex) of
            int curIndex = k / mod;
            // update k
            k = k % mod;
 
            // get number according to curIndex
            result += numberList.get(curIndex);
            // remove from list
            numberList.remove(curIndex);
        }
 
        return result.toString();
    }
    
    
}