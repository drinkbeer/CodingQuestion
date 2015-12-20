/*
LeetCode: https://leetcode.com/problems/unique-binary-search-trees/
LintCode: http://www.jiuzhang.com/solutions/unique-binary-search-trees/
JiuZhang: http://www.lintcode.com/problem/unique-binary-search-trees/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-java/

Analysis: 
count[i] be the # of unique binary tree nodes when index == i

count[0]=1  enpty tree

count[1]=1  one tree

count[2]=count[0]*count[1]  1 is root
        +count[1]*count[0]  2 is root
        
count[3]=count[0]*count[2]  1 is root
        +count[1]*count[1]  2 is root
        +count[2]*count[0]  3 is root
        
count[4]=count[0]*count[3]  1 is root
        +count[1]*count[2]  2 is root
        +count[2]*count[1]  3 is root
        +count[3]*count[0]  4 is root

So, DP state function, count[n] = SUM(count[0...k]*count[k+1...n-1]), 0 <= k < n-1
*/

public class Solution {
    public int numTrees(int n) {
        int[] count = new int[n + 1];
        
        count[0] = 1;
        count[1] = 1;
        
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= i - 1; j++){
                count[i] = count[i] + count[j] * count[i - 1 - j];
            }
        }
        
        return count[n];
    }
}